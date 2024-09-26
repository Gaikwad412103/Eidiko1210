package one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        if (sessionFactory == null) {
            System.out.println("SessionFactory is not created!!!");
            return;
        }

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            //------------------First Department with Employees-----------------------
            Department departmentJava = new Department();
            departmentJava.setName("Java");

            Employees employeeAvinash = new Employees();
            employeeAvinash.setName("Avinash");
            employeeAvinash.setDepartment(departmentJava);

            departmentJava.getEmployeesList().add(employeeAvinash); // Linking the employee with the department

            //------------------Second Department with Employees-----------------------
            Department departmentAPI = new Department();
            departmentAPI.setName("API");

            Employees employeeTanmay = new Employees();
            employeeTanmay.setName("Tanmay");
            employeeTanmay.setDepartment(departmentAPI);

            Employees employeeShwet = new Employees();
            employeeShwet.setName("Shwet");
            employeeShwet.setDepartment(departmentAPI);

            departmentAPI.getEmployeesList().add(employeeTanmay); // Linking the employee with the department
            departmentAPI.getEmployeesList().add(employeeShwet);  // Linking the employee with the department

            //------------------Third Department with Employees-----------------------
            Department departmentIIB = new Department();
            departmentIIB.setName("IIB");

            Employees employeeAbhishek = new Employees();
            employeeAbhishek.setName("Abhishek");
            employeeAbhishek.setDepartment(departmentIIB);

            departmentIIB.getEmployeesList().add(employeeAbhishek); // Linking the employee with the department

            // Persisting departments (cascading will persist employees as well)
            session.save(departmentJava);
            session.save(departmentAPI);
            session.save(departmentIIB);

            transaction.commit();

            System.out.println("Records saved successfully!!!!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
