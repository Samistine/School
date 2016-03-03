/****************************************
 *      Lab 4                           *
 *      Samuel Seidel                   *
 *      February 11, 2016               *
 ****************************************/

public class TempLoops {

    public static void main(String[] args) {
        

        int[] fahrArray = new int[16];
        double[] celsArray = new double[16];

        int x = 0;
        for (int fahrenheit = 0; fahrenheit <= 300; fahrenheit += 20) {//Initialize variable, Check Condition, Increment
                //Calculate Celsius Temperature
                double celsius = (fahrenheit - 32.0) * (5.0/9.0);
                
                //store fahr
                fahrArray[x] = fahrenheit;
                //store cels
                celsArray[x] = celsius;

                //increment variable
                x++;
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|Fahrenheit |     Celsius |");
        System.out.println("|-------------------------|");
        for (int i = 0; i < 16; i++) {
                //Retrieve fahrenheit
                int fahrenheit = fahrArray[i];
                //Retrieve celsius
                double celsius = celsArray[i];

                //@See http://web.cerritos.edu/jwilson/SitePages/java_language_resources/Java_printf_method_quick_reference.pdf
                System.out.printf("|%4d*F     |    % 6.1f*C |%n",      fahrenheit       ,  celsius  );
        }
        System.out.println("|_________________________|");
    }

}
