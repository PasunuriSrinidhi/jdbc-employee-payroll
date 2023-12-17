/*import java.sql.Date;

public class Employee {
    public int Id;
    public String firstName;
    public String lastName;
    public float basicPay;
    public Date Start_Date;


    public Date getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.Start_Date = start_Date;
    }
    
    public float getBasicPay() {
        return basicPay;
    }
    public void setBasicPay(float basicPay) {
        this.basicPay = basicPay;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
     @Override
    public String toString() {
        return "Employee [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", basicPay=" + basicPay
                + ", Start_Date=" + Start_Date + "]";
    }
}
*/
public class Employee {
    private String name;
    private String start_date;
    private String gender;
    private String phone;
    private String address;
    private double salary;
    private double deductions;
    private double taxable_pay;
    private double income_tax;
    private double net_pay;
    private String department;

    public Employee(String name, String start_date, String gender, String phone, String address, double salary,
            double deductions, double taxable_pay, double income_tax, double net_pay, String department) {
        this.name = name;
        this.start_date = start_date;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
        this.deductions = this.salary * 0.2;
        this.taxable_pay = this.salary - this.deductions;
        this.income_tax =  this.taxable_pay * 0.1;
        this.net_pay = this.salary - this.income_tax;
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public String getStartDate() {
        return this.start_date;
    }

    public String getGender() {
        return this.gender;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    public double getSalary() {
        return this.salary;
    }

    public double getDeductions() {
        return this.deductions;
    }

    public double getTaxablePay() {
        return this.taxable_pay;
    }

    public double getIncomeTax() {
        return this.income_tax;
    }

    public double getNetPay() {
        return this.net_pay;
    }

    public String getDepartment() {
        return this.department;
    }

    // method to convert to CSV String
    public String toCSVString() {
        return this.name + ","
                + this.start_date + ","
                + this.gender + ","
                + this.phone + ","
                + this.address + ","
                + this.salary + ","
                + this.deductions + ","
                + this.taxable_pay + ","
                + this.income_tax + ","
                + this.net_pay + ","
                + this.department;
    }

    @Override
    public String toString() {
        return "Name: " + this.name
                + "\nStart Date: " + this.start_date
                + "\nGender: " + gender
                + "\nPhone: " + this.phone
                + "\nAddress: " + this.address
                + "\nSalary: " + this.salary
                + "\nDeductions: " + this.deductions
                + "\nTaxable Pay: " + this.taxable_pay
                + "\nIncome Tax: " + this.income_tax
                + "\nNet Pay: " + this.net_pay
                + "\nDepartment: " + this.department;
    }
}
