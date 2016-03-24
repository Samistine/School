/****************************************
 *      Lab 9                           *
 *      Samuel Seidel                   *
 *      March 24, 2016                  *
 ****************************************/

public class Employee extends Person{

    private int employeeID;
    private double salary;

    public Employee() {
        super();
        this.employeeID = 0;
        this.salary = 0.0;
    }
    public Employee(String first_name, String last_name, String address, String email, int employeeID, double salary) {
        super(first_name, last_name, address, email);
        this.employeeID = employeeID;
        this.salary = salary;
    }

    public int getEmployeeID() {return this.employeeID;}
    public double getSalary() {return this.salary;}

    public void setEmployeeID(int employeeID) {this.employeeID = employeeID;}
    public void setSalary(double salary) {this.salary = salary;}

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Employee{"+ ("FirstName=\""+getFirstName()+"\"") +", "+ ("LastName=\""+getLastName()+"\"") +", "+ ("Address=\""+getAddress()+"\"") +", "+ ("Email=\""+getEmail()+"\"") +", "+ ("EmployeeID="+employeeID) +", "+ ("Salary="+salary) +"}";
    }

    public static void main(String[] args) {
        Employee e1;
        e1 = new Employee("Bill", "Clinton", "Marietta", "bc@msn.com", 2323, 43000.00);
        e1.display();      //prints all 6 properties
    }
}