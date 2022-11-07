import Model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

public class ManageEmployee {
   private static SessionFactory factory;

   public static void main(String[] args) {
      
      try {
         factory = new AnnotationConfiguration().
                   configure().
                   //addPackage("com.xyz") //add package if used.s
                   addAnnotatedClass(Employee.class).
                   buildSessionFactory();
      } catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      
      ManageEmployee ME = new ManageEmployee();

      /* Add few employee records in database */
      Integer empID1 = ME.addEmployee(1, "Zara", "Ali", 1000);
      Integer empID2 = ME.addEmployee(2,"Daisy", "Das", 5000);
      Integer empID3 = ME.addEmployee(3, "John", "Paul", 10000);

      /* List down all the employees */
      ME.listEmployees();

      /* Update employee's records */
      ME.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
      ME.deleteEmployee(empID2);

      /* List down new list of the employees */
      ME.listEmployees();
   }
   
   /* Method to CREATE an employee in the database */
   public Integer addEmployee(int id, String firstName, String lastName, int salary){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      
      try {
         tx = session.beginTransaction();



//         Employee employee = new Employee();
//         employee.setId(id);
//         employee.setFirstName(firstName);
//         employee.setLastName(lastName);
//         employee.setSalary(salary);
//         employeeID = (Integer) session.save(employee);
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return employeeID;
   }
   
   /* Method to  READ all the employees */
   public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
//         List employees = session.createQuery("FROM Employee").list();
//         for (Object o : employees) {
//            Employee employee = (Employee) o;
//            System.out.print("First Name: " + employee.getFirstName());
//            System.out.print("  Last Name: " + employee.getLastName());
//            System.out.println("  Salary: " + employee.getSalary());
//         }
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
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
//         employee.setSalary( salary );
		 session.update(employee); 
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
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         session.delete(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
}