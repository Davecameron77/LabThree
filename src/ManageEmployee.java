import Model.*;
import Model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ManageEmployee {
   public static void main(String[] args) {

      try {
         factory = new Configuration()
                        .configure()
                        .addAnnotatedClass(Person.class)
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Customer.class)
                        .addAnnotatedClass(FullAddress.class)
                        .addAnnotatedClass(FullName.class)
                        .addAnnotatedClass(Task.class)
                        .buildSessionFactory();
      } catch (Throwable ex) {
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex);
      }

      addEmployee("Rob", "Stark");
      addEmployee("John", "Snow");
      addEmployee("Sansa", "Stark");
      addEmployee("Arya", "Stark");
      addEmployee("Bran", "Stark");

      listEmployees();
//      ManageEmployee ME = new ManageEmployee();
//
//      /* Add few employee records in database */
//      Integer empID1 = ME.addEmployee("Zara", "Ali");
//      Integer empID2 = ME.addEmployee("Daisy", "Das");
//      Integer empID3 = ME.addEmployee("John", "Paul");
//
//      /* List down all the employees */
//      ME.listEmployees();
//
//      /* Update employee's records */
//      ME.updateEmployee(empID1, 5000);
//
//      /* Delete an employee from the database */
//      ME.deleteEmployee(empID2);
//
//      /* List down new list of the employees */
//      ME.listEmployees();
   }

   private static SessionFactory factory;

   /* Method to CREATE an employee in the database */
   public static void addEmployee(String firstName, String lastName){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = new Employee();
         employee.setFirstName(firstName);
         employee.setLastName(lastName);
         session.persist(employee);
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to  READ all the employees */
   public static void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         String query = "FROM EMPLOYEE WHERE 1=1";
         List employees = session.createQuery(query).list();
         for (Object o : employees) {
            Employee employee = (Employee) o;
            System.out.print("First Name: " + employee.getFirstName());
            System.out.print("  Last Name: " + employee.getLastName());
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to UPDATE salary for an employee */
   public void updateEmployee(Integer EmployeeID, int salary ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = session.get(Employee.class, EmployeeID);
		 session.persist(employee);
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to DELETE an employee from the records */
   public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = session.get(Employee.class, EmployeeID);
         session.remove(employee);
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
}