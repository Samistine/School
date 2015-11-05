package Assignment11;

/**
 * Assignment 11 Question 4
 * <p>
 * Modify
 * {@link Assignment10.Student the Student class that you built in Assignment #8}.
 * Add to the pseudo-code that you wrote in Assignment #8. Add 2 Constructors to
 * this class. The first Constructor should be the “no args” constructor. This
 * constructor should take no arguments and initialize all the properties to 0
 * or “”(empty string). The second constructor should accept 6 arguments, one
 * for firstName, one for lastname, one for address, one for email, one for
 * major and one for gpa. This data being passed in should be put into the
 * properties of this object.
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

    public Student() {
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.emailAddress = "";
        this.major = "";
        this.GPA = 0;
    }

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
