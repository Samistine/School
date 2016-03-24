/****************************************
 *      Lab 9                           *
 *      Samuel Seidel                   *
 *      March 24, 2016                  *
 ****************************************/

public class Teller extends Employee {

    private double hoursWorked;
    private String shift;

    public Teller() {
        super();
        this.hoursWorked = 0.0;
        this.shift = "";
    }
    public Teller(String first_name, String last_name, String address, String email, int employeeID, double salary, double hoursWorked, String shift) {
        super(first_name, last_name, address, email, employeeID, salary);
        this.hoursWorked = hoursWorked;
        this.shift = shift;
    }

    public double getHoursWorked() {return this.hoursWorked;}
    public String getShift() {return this.shift;}

    public void setHoursWorked(int hoursWorked) {this.hoursWorked = hoursWorked;}
    public void setShift(String shift) {this.shift = shift;}

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Teller{"+ ("FirstName=\""+getFirstName()+"\"") +", "+ ("LastName=\""+getLastName()+"\"") +", "+ ("Address=\""+getAddress()+"\"") +", "+ ("Email=\""+getEmail()+"\"") +", "+ ("EmployeeID="+getEmployeeID()) +", "+ ("Salary="+getSalary()) +", "+ ("HoursWorkedThisWeek="+hoursWorked) +", "+ ("Shift=\""+shift+"\"") +"}";
    }

}