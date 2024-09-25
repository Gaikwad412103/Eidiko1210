package CrudApplication;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class EmployeeDao {

    private SessionFactory sessionFactory;
    private Scanner sc;

    public EmployeeDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.sc = new Scanner(System.in);
    }

    //-----------------Insert Operation--------------------------
    public void saveEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            System.out.println("Record inserted Successfully!!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback transaction if an error occurs
            }
            e.printStackTrace();
        }
    }

    public void getEmployeeDetails(long id) {
        try (Session session = sessionFactory.openSession()) {
            Employee employee = session.get(Employee.class, id);
            if (employee == null) {
                System.out.println("Employee does not exist!!");
            } else {
                System.out.println(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee == null) {
                System.out.println("Employee does not exist!!");
            } else {
                System.out.println("Enter Name & City");
                String name = sc.nextLine();
                String city = sc.nextLine();

                employee.setName(name);
                employee.setCity(city);
                session.update(employee);
                transaction.commit();
                System.out.println("Employee Details Updated SuccessFully!!");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback transaction if an error occurs
            }
            e.printStackTrace();
        }
    }

    public void deleteEmployee(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee == null) {
                System.out.println("Employee does not exist!!");
            } else {
                session.delete(employee);
                transaction.commit();  // Commit after delete
                System.out.println("Employee Deleted Successfully!!");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback transaction if an error occurs
            }
            e.printStackTrace();
        }
    }
}
