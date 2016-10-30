import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit04
 * Date: Created Oct 7, 2016 1:05:00 AM
 *
 * By turning in this code, I Pledge:
 * 1. That I have completed the programming assignment independently.
 * 2. I have not copied the code from a student or any source.
 * 3. I have not given my code to any student.
 *
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
public class Unit04Prog01 {

    /**
     * Open the file.
     *
     * @param file file to open
     */
    static void openFile(File file) {
        try (Scanner scanner = new Scanner(file)) {

            //Running total
            double numbers = 0;

            /* Iterate thru numeric entries in text file */
            while (scanner.hasNextBigDecimal()) {
                double number = scanner.nextDouble();
                /* Add the value to the running total */
                numbers += number;
            }

            /* Append To Console */
            System.out.println("Total is " + numbers + System.lineSeparator());

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + file.getName() + "'");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Error reading file '" + file.getName() + "'");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* Prompt */
        System.out.print("Please enter the name of the scores file: ");

        /* Get User Input */
        String line = scanner.nextLine();

        /* File for input */
        File file = new File(line);

        /* Exit, with message, if file doesn't exist */
        if (!file.exists() || !file.isFile()) {
            System.out.println("Sorry, file '" + file.getName() + "' not found.");
            return;
        }

        /* Open File */
        openFile(file);
    }

}
