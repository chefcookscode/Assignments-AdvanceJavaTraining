import java.sql.*;
import java.util.Scanner;

public class AddNewStudentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter UserID: ");
        int userID = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Percentage: ");
        float percentage = sc.nextFloat();

        System.out.print("Enter JEE Percentile: ");
        float jeePercentile = sc.nextFloat();

        System.out.print("Enter Admission Year: ");
        int admissionYear = sc.nextInt();

        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String username = "root";
        String password = "HIDDEN-ON-PURPOSE"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            String query = "INSERT INTO Students(UserID, Name, Percentage, JEEPercentile, AdmissionYear) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, userID);
            pst.setString(2, name);
            pst.setFloat(3, percentage);
            pst.setFloat(4, jeePercentile);
            pst.setInt(5, admissionYear);

            int rows = pst.executeUpdate();
            if(rows > 0) {
                System.out.println("Student added successfully!");
            }

            con.close();
            sc.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
