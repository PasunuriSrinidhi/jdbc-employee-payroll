import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeePayroll
{

   

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Scanner s = new Scanner(System.in);
        System.out.println("Press 1 to Insert Data\nPress 2 to Reterive data");
        int choice = s.nextInt();

        switch(choice) {
            case 1:
                insertData();
                break;
            case 2:
                reteriveData();
                break;
              case 3:
                UpdateData();
                break;
        }

    }


    private static void reteriveData() throws SQLException {
        EmployeeRepo repo = new EmployeeRepo();
        List<Employee> details = repo.findAll();
        details.forEach(System.out::println);
    }

    private static void insertData() throws ClassNotFoundException, SQLException {
        System.out.println("Enter FirstName");
        Employee details = new Employee();
        details.setFirstName(s.next());

        System.out.println("Enter LastName");
        details.setLastName(s.next());

        EmployeeRepo repo = new EmployeeRepo();
        repo.insertRecord(details);

    }
 private static void UpdateData() throws SQLException {

        System.out.println("Enter Id");
        int id = s.nextInt();

        System.out.println("Enter BasicPay");
        float basicPay = s.nextFloat();

        EmployeeRepo repo = new EmployeeRepo();
        repo.updatedata(id, basicPay);

    }

}
