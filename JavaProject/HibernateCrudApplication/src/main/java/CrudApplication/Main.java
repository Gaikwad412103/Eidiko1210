package CrudApplication;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        EmployeeDao employeeDao=new EmployeeDao(sessionFactory);
        Scanner sc=new Scanner(System.in);
        System.out.println("1: Insert Record\n2: FetchRecord\n3: Update Record \n4: Delete Record");
        int a=sc.nextInt();
        long id=0;
        switch (a){
            case 1:
                Employee employee=new Employee();
                System.out.println("Enter ID, Name, City ");
                id=sc.nextLong();
                sc.nextLine();
                String name=sc.nextLine();
                String city=sc.nextLine();
                employee.setId(id);
                employee.setName(name);
                employee.setCity(city);
                employeeDao.saveEmployee(employee);
                break;
            case 2:
                System.out.println("Enter Employee Id");
                id=sc.nextLong();
                employeeDao.getEmployeeDetails(id);
                break;
            case 3:
                System.out.println("Enter Employee Id");
                id=sc.nextLong();
                employeeDao.updateEmployee(id);
                break;
            case 4:
                System.out.println("Enter Employee Id");
                id=sc.nextLong();
                employeeDao.deleteEmployee(id);
                break;
            default:
                System.out.println("Choice Correct Option!!");
                break;

        }
    }
}
