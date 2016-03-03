/****************************************
 *      Lab 6                           *
 *      Samuel Seidel                   *
 *      March 3, 2016                   *
 ****************************************/

public class SimpleArray {

    public static void main(String[] args) {
        //Init array
        int[] intArray = new int[100];

        int x = 500;

        //Put values into array
        for (int i = 0; i < 100; i++) {
            intArray[i] = x++;
        }

        //Print out array
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
        
    }

}
