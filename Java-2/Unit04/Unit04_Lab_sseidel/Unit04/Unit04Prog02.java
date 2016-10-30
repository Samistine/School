import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit04
 * Date: Created Oct 7, 2016 1:33:55 AM
 *
 * By turning in this code, I Pledge:
 * 1. That I have completed the programming assignment independently.
 * 2. I have not copied the code from a student or any source.
 * 3. I have not given my code to any student.
 *
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
public class Unit04Prog02 {

    public static void main(String[] args) throws IOException {
        //Get file props
        File file = new File("CreateData.dat");

        //Create file if it doesn't exist
        if (!file.exists()) {
            file.createNewFile();
        }

        //Open output stream
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            //Loop 100 times
            for (int i = 0; i < 100; i++) {
                //Write out a random integer between 0 and 1,000
                out.writeInt(new Random().nextInt(1_000));
            }
        }

        //Open input stream
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
            //Loop until datastream ends
            while (is.available() > 0) {
                //Read int from stream
                int value = is.readInt();
                //Print out int value
                System.out.println(value);
            }
        }

    }

}
