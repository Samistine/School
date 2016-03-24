/****************************************
 *      Lab 9                           *
 *      Samuel Seidel                   *
 *      March 24, 2016                  *
 ****************************************/

public class Student extends Person{

    private int studentID;
    private String major;
    private double gpa;

    public Student() {
        super();
        this.studentID = 0;
        this.major = "";
        this.gpa = 0;
    }
    public Student(String first_name, String last_name, String address, String email, int studentID, String major, double gpa) {
        super(first_name, last_name, address, email);
        this.studentID = studentID;
        this.major = major;
        this.gpa = gpa;
    }

    public int getStudentID() {return this.studentID;}
    public String getMajor() {return this.major;}
    public double getGPA() {return this.gpa;}

    public void setStudentID(int studentID) {this.studentID = studentID;}
    public void setMajor(String major) {this.major = major;}
    public void setGPA(double gpa) {this.gpa = gpa;}

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Student{"+ ("FirstName=\""+getFirstName()+"\"") +", "+ ("LastName=\""+getLastName()+"\"") +", "+ ("Address=\""+getAddress()+"\"") +", "+ ("Email=\""+getEmail()+"\"") +", " + ("StudentID="+studentID) +", "+ ("Major=\""+major+"\"") +", "+ ("GPA="+gpa) +"}";
    }

    public static void main(String[] args) {
        Student student = new Student("Samuel", "Seidel", "Somewhere over the rainbow", "whereami@really.me", 900, "Computer Programming", 3.8);
        student.display();
    }
}