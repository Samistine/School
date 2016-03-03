/****************************************
 *      Lab 4                           *
 *      Samuel Seidel                   *
 *      February 11, 2016               *
 ****************************************/

public class Reverse3 {

    public static void main(String[] args) {
        char name[] = {'S', 't', 'e', 'v', 'e'};
        reverse3(name);
    }

    static void reverse3(char[] chars) {
        for (int i = chars.length-1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }

}
