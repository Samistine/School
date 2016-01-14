package Assignment7;

/**
 * Design the pseudocode/flowchart for a program that uses a while loop to
 * output numbers between 0 and 100, stepping by 5. (ie. 0, 5, 10, 15…) Your
 * output should go to the console window.
 *
 * @author sseidel
 */
public class Question2 {

    public void run() {
        int x = 0;
        while (x <= 100) {
            System.out.println(x);
            x = x + 5;
        }
    }

    public static void main(String[] args) {
        new Question2().run();
    }
}
