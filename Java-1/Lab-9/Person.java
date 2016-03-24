/****************************************
 *      Lab 7                           *
 *      Samuel Seidel                   *
 *      March 10, 2016                  *
 ****************************************/

public class Person {

    private String first_name;
    private String last_name;
    private String address;
    private String email;

    public Person() {
        //this("", "", "", "");
        this.first_name = "";
        this.last_name = "";
        this.address = "";
        this.email = "";
    }
    public Person(String first_name, String last_name, String address, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
    }

    public String getFirstName() {return this.first_name;}
    public String getLastName() {return this.last_name;}
    public String getAddress() {return this.address;}
    public String getEmail() {return this.email;}

    public void setFirstName(String first_name) {this.first_name = first_name;}
    public void setLastName(String last_name) {this.last_name = last_name;}
    public void setAddress(String address) {this.address = address;}
    public void setEmail(String email) {this.email = email;}

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Person{"+ ("FirstName=\""+first_name+"\"") +", "+ ("LastName=\""+last_name+"\"") +", "+ ("Address=\""+address+"\"") +", "+ ("Email=\""+email+"\"") +"}";
    }

    public static void main(String[] args) {
        Person person1 = new Person("Sam", "Seidel", "123 Liverview Drive", "me@whoami.com");
        person1.display();
    }
}
