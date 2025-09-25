import java.sql.*;
import java.util.Scanner;

public class CheckEligibilityForBranchChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter UserID to fetch details: ");
        int userID = sc.nextInt();

        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String username = "root"; 
        String password = "HIDDEN-ON-PURPOSE"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM Students WHERE UserID = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, userID);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                System.out.println("UserID: " + rs.getInt("UserID"));
                System.out.println("Name: " + rs.getString("Name"));
                System.out.println("Percentage: " + rs.getFloat("Percentage"));
                System.out.println("JEE Percentile: " + rs.getFloat("JEEPercentile"));
                System.out.println("Admission Year: " + rs.getInt("AdmissionYear"));
            
                if (rs.getFloat("Percentage") > 80) {
                    System.out.println("ELIGIBLE FOR BRANCH CHANGE");
                } else {
                    System.out.println("NOT ELIGIBLE FOR BRANCH CHANGE");
                }

            } else {
                System.out.println("Student not found.");
            }

            con.close();
            sc.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
