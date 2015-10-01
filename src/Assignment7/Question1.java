package Assignment7;

/**
 * Design the pseudocode/flowchart for a program that outputs numbers in reverse
 * order from 10 down to 1. Your output should go to the console window. Use a
 * loop with step -1.
 *
 * @author sseidel
 */
public class Question1 {

    public void run() {
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new Question1().run();
    }
}
