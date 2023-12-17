import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {

    public void insertRecord(EmployeeDetails details) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement prestatement = null;
        try {
            //Step1: Load & Register Driver Class
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());

            //Step2: Establish a MySql Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_payroll_service", "root", "root");
            
            //Step3: Create Statement
            String query =" select * from employee_payroll ";
            prestatement = connection.prepareStatement(query);

            //Step4: Execute Query
            ResultSet resultset = prestatement.executeQuery();

            while(resultset.next()) {
                Employee info = new Employee();

                int id=resultset.getInt(1);
                info.setId(id);

                String name = resultset.getString(2);
                info.setFirstName(name);

                String lastname = resultset.getString(3);
                info.setLastName(lastname);

                float pay =resultset.getFloat(4);
                info.setBasicPay(pay);

                details.add(info);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {

            if(connection != null) {
                prestatement.close();
            }
            if(prestatement != null) {
                connection.close();
            }
        }
        return details;
    }

    public void updatedata(int id, float basicPay) throws SQLException {
        Connection con = null;
        PreparedStatement prestatement = null;
        try {

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_payroll_service", "root", "root");

            String query ="Update employee_payroll set basic_pay=? where Id=?";
            prestatement = con.prepareStatement(query);
            prestatement.setFloat(1, basicPay);
            prestatement.setInt(2, id);
            prestatement.executeUpdate();
            System.out.print("Records Updated!");

        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(con != null) {
                prestatement.close();
            }
            if(prestatement != null) {
                con.close();
            }
        }
    }
}
