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

    public Course() {
        //this(0, "", "", 0);
        this.courseID = 0;
        this.courseName = "";
        this.description = "";
        this.creditHours = 0;
    }
    public Course(int courseID, String courseName, String description, int creditHours) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.description = description;
        this.creditHours = creditHours;
    }

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
        c1 = new Course(323, "Intro to Php", "Intro to Php Programming",  4);
        c1.display();
    }
}
