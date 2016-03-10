/****************************************
 *      Lab 7                           *
 *      Samuel Seidel                   *
 *      March 10, 2016                  *
 ****************************************/

public class Course {

    private int courseID;
    private String courseName;
    private String description;
    private int creditHours;

    public int getCourseID() {return this.courseID;}
    public String getCourseName() {return this.courseName;}
    public String getDescription() {return this.description;}
    public int getCreditHours() {return this.creditHours;}

    public void setCourseID(int courseID) {this.courseID = courseID;}
    public void setCourseName(String courseName) {this.courseName = courseName;}
    public void setDescription(String description) {this.description = description;}
    public void setCreditHours(int creditHours) {this.creditHours = creditHours;}

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", courseName=\"" + courseName + "\", description=\"" + description + "\", creditHours=" + creditHours + "}";
    }

    public static void main(String[] args) {
        Course c1;
        c1 = new Course();
        c1.setCourseID(109);
        c1.setCourseName("Intro to Python");
        c1.setDescription("This course intros the Python Prog Lang.");
        c1.setCreditHours(4);
        c1.display();
    }
}
