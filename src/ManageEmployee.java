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

      System.out.println("*******************************************************");
      System.out.println("Creating employees");
      System.out.println("*******************************************************");
      addEmployee("Rob", "Stark");
      addEmployee("John", "Snow");
      addEmployee("Sansa", "Stark");
      addEmployee("Arya", "Stark");
      addEmployee("Bran", "Stark");
      System.out.println();

      System.out.println("*******************************************************");
      System.out.println("Updating employees");
      System.out.println("*******************************************************");
      updateEmployee(1);
      updateEmployee(2);
      System.out.println();

      System.out.println("*******************************************************");
      System.out.println("Listing employees");
      System.out.println("*******************************************************");
      listEmployees();
      System.out.println();

      System.out.println("*******************************************************");
      System.out.println("Deleting employees");
      System.out.println("*******************************************************");
      deleteEmployee(4);
      deleteEmployee(5);
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
         System.out.println("Created employee: " + employee.getFirstName() + " " + employee.getLastName());
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
         String query = "FROM Model.Employee WHERE 1=1";
         List employees = session.createQuery(query).list();
         for (Object o : employees) {
            Employee employee = (Employee) o;
            System.out.print("First Name: " + employee.getFirstName());
            System.out.print("  Last Name: " + employee.getLastName() + "\n");
            System.out.print("Tasks: ");
            List<Task> employeeTasks = employee.getTasks();
            if (!employeeTasks.isEmpty()) {
               for (Task task : employeeTasks) {
                  System.out.print(task.getServiceType() + ", ");
               }
               System.out.print("\n");
            } else {
               System.out.print("None Assigned\n");
            }
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
   public static void updateEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = session.get(Employee.class, EmployeeID);

         Task newTask = new Task();
         newTask.setServiceType("Food preparation");
         newTask.setDuration(1);
         employee.addTask(newTask);

         Task newTaskTwo = new Task();
         newTaskTwo.setServiceType("Nursing");
         newTaskTwo.setDuration(2);
         employee.addTask(newTaskTwo);

         System.out.println("Assigned tasks Food Preperation and Nursing to " + employee.getFirstName() + " " + employee.getLastName());

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
   public static void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = session.get(Employee.class, EmployeeID);
         session.remove(employee);
         tx.commit();
         System.out.println("Deleted " + employee.getFirstName() + employee.getLastName());
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
}