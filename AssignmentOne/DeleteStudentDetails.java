import java.sql.*;
import java.util.Scanner;

public class DeleteStudentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter UserID of student to delete: ");
        int userID = sc.nextInt();

        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String username = "root"; 
        String password = "HIDDEN-ON-PURPOSE"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            
            String query = "DELETE FROM Students WHERE UserID = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, userID);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Student with UserID " + userID + " deleted successfully!");
            } else {
                System.out.println("No student found with UserID " + userID);
            }

            con.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
