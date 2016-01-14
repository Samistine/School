package Assignment8;

/**
 * Assignment 8 Question 3<br/>
 * Write the pseudo-code/flowchart for an application that uses 2 Arrays. The
 * first Array should store Fahrenheit temperatures. The Fahrenheit temps should
 * start at 0 and go up to 300, incrementing by 30. The second Array should
 * store the equivalent Celsius temperatures. (Formula is: Celsius =
 * (Fahrenheit-32.0) * (5.0/9.0)). After you have stored this data in these two
 * arrays, print out the data to the output console. Don’t worry about
 * formatting the Celsius data.
 *
 * @author sseidel
 */
public class Question3 {

    int startingTemp = 0;
    int endingTemp = 300;
    int step = 30;

    public void run() {
        int iterations = ((endingTemp - startingTemp) / step) + 1;
        float faren[] = new float[iterations];
        float cels[] = new float[iterations];

        for (int temp = startingTemp; temp <= endingTemp; temp += step) {
            int index = temp / step;
            faren[index] = temp;
            cels[index] = ((temp - 32) * (5.0f / 9.0f));
        }

        System.out.println("~~~Fahrenheit Array~~~");
        for (int i = 0; i < iterations; i++) {
            System.out.println(faren[i]);
        }

        System.out.println("~~~Celsius Array~~~");
        for (int i = 0; i < iterations; i++) {
            System.out.println(cels[i]);
        }

    }

    public static void main(String[] args) {
        new Question3().run();
    }
}
