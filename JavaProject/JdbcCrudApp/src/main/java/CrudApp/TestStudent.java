package CrudApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class TestStudent {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String userName = "system";
            String userPass = "root";
            Connection con = DriverManager.getConnection(url, userName, userPass);
            if (con == null) {
                System.out.println("Connection is not created");
            } else {
                System.out.println("1: Add Student \n2: Retrieve All Students Info \n3: Update Student \n4: Delete Student Record");
                int n = sc.nextInt();
                switch (n) {
                    case 1:
                        Student.addStudent(con);
                        break;
                    case 2:
                        Student.retrieveRecords(con);
                        break;
                    case 3:
                        Student.updateStudent(con);
                        break;
                    case 4:
                        Student.removeStudent(con);
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
