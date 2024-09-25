package CrudApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
    public static Scanner sc = new Scanner(System.in);

    //------------------Add Student--------------------------
    public static void addStudent(Connection con) {
        String query = "insert into student values(?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            System.out.println("Enter ID, Name, City :");
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String city = sc.nextLine();
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, city);
            int i = ps.executeUpdate();
            if (i == 1) {
                System.out.println("Student Added Successfully!!!");
            } else {
                System.out.println("Student Not Added!!!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //---------------------------Retrieve All Records----------------------------------

    public static void retrieveRecords(Connection con) {
        String query = "select * from student";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("******************* Student Data *********************");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String city = rs.getString(3);
                System.out.println("-----------------------------------------------------------");
                System.out.println("Id: " + id + " Name: " + name + " City: " + city);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //----------------------------Delete Record------------------------------------

    public static void removeStudent(Connection con) {
        String query = "delete from student where sid=?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            System.out.println("Enter Id:");
            int id = sc.nextInt();
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                System.out.println("Record Deleted Successfully!!!");
            } else {
                System.out.println("Record Is Not Present!!!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //----------------------------Update Record based on id-------------------------

    public static void updateStudent(Connection con) {
        String query = "update student set sname=?, city=? where sid=?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            System.out.println("Enter Id:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter New Name:");
            String name = sc.nextLine();
            System.out.println("Enter New City:");
            String city = sc.nextLine();
            ps.setString(1, name);
            ps.setString(2, city);
            ps.setInt(3, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                System.out.println("Record Updated Successfully!!!");
            } else {
                System.out.println("Record Not Found!!!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
