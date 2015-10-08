package Assignment8;

import java.util.Scanner;

/**
 * <b>Assignment 8 Question 4</b> (Extra Credit – 10 Points)
 * <p>
 * The Midville Park District maintains five soccer teams, as shown in the table
 * below. Design a Visual Logic flowchart that accepts a player’s team number
 * and displays the player’s team name. Check for an invalid team number (a
 * number that is not between 1 and 5 inclusive) and issue an error message and
 * then continue on to the next input. Keep accepting team numbers and printing
 * out an appropriate message until a sentinal value is input (zero, 0), then
 * quit. (Hint: Use an Array to store the team names, for easy access to these
 * team names.)
 * </p>
 *
 * <ol><b>Team Name</b>
 * <li>Goal Getters</li>
 * <li>The Force</li>
 * <li>Top Guns</li>
 * <li>Shooting Stars</li>
 * <li>Midfield Monsters</li>
 * </ol>
 *
 * @author sseidel
 */
public class Question4 {

    static String[] teams = new String[]{
        "", //Spacer
        "Goal Getters", //Team 1
        "The Force", //Team 2
        "Top Guns", //Team 3
        "Shooting Stars", //Team 4
        "Midfield Monsters" //Team 5
    };

    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Enter a team number");
        int userInput;
        do {
            userInput = scanner.nextInt();
            try {
                String teamname = teams[userInput];
                if (!teamname.isEmpty()) {
                    System.out.println("Team \"" + teamname + "\"\r\n");
                } else {
                    System.out.println("~~~Goodbye!~~~");
                }
            } catch (ArrayIndexOutOfBoundsException invalidOption) {
                System.err.println("INVALID TEAM NUMBER\r\n"
                        + "You have entered a number that does not correlate with any team names");
            }
        } while (userInput != 0);
    }

    public static void main(String[] args) {
        new Question4().run();
    }
}
