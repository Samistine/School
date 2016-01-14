package Assignment10;

/**
 * Assignment 10 Question 4<br/>
 * Design a class named Student. The Student class should have a Firstname, a
 * Lastname, an Address, an email address, a major and a GPA. Determine the data
 * types for each property, then create the class diagram and write the
 * pseudo-code that defines the class.
 *
 * @author sseidel
 */
public class Student {

    private String firstName;
    private String lastName;
    private String address;
    private String emailAddress;
    private String major;
    private float GPA;

    public Student(String firstName, String lastName, String address, String emailAddress, String major, float GPA) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.major = major;
        this.GPA = GPA;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getMajor() {
        return major;
    }

    public float getGPA() {
        return GPA;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

}
