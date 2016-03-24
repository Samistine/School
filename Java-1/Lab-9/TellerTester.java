/****************************************
 *      Lab 9                           *
 *      Samuel Seidel                   *
 *      March 24, 2016                  *
 ****************************************/

public class TellerTester {

    public static void main(String[] args) {
        Teller teller = new Teller("Bill", "Clinton", "Marietta", "bc@msn.com", 2323, 43000.00, 50, "evening");
        teller.display();
    }

}