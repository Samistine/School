/****************************************
 *      Lab 4                           *
 *      Samuel Seidel                   *
 *      February 11, 2016               *
 ****************************************/

public class TempLoops {

    public static void main(String[] args) {
        
//<For-Loop>
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|Fahrenheit |     Celsius |");
        System.out.println("|-------------------------|");

        for (int fahr = 0; fahr <= 300; fahr += 20) {//Initialize variable, Check Condition, Increment
                //Calculate Celsius Temperature
                double celsius = (fahr - 32.0) * (5.0/9.0);
                //@See http://web.cerritos.edu/jwilson/SitePages/java_language_resources/Java_printf_method_quick_reference.pdf
                System.out.printf("|%4d*F     |    % 6.1f*C |%n",      fahr       ,  celsius  );
        }

        System.out.println("|_________________________|");
//</For-Loop>

//<While-Loop>
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|Fahrenheit |     Celsius |");
        System.out.println("|-------------------------|");

        int fahr2 = 0; //Initialize variable
        while (fahr2 <= 300) { //Check Condition
                //Calculate Celsius Temperature
                double celsius = (fahr2 - 32.0) * (5.0/9.0);
                //@See http://web.cerritos.edu/jwilson/SitePages/java_language_resources/Java_printf_method_quick_reference.pdf
                System.out.printf("|%4d*F     |    % 6.1f*C |%n",      fahr2       ,  celsius  );
                //Increment
                fahr2 += 20;
        }

        System.out.println("|_________________________|");
//</While-Loop>

//<Do-While-Loop>
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|Fahrenheit |     Celsius |");
        System.out.println("|-------------------------|");

        int fahr3 = 0; //Initialize variable
        do {
                //Calculate Celsius Temperature
                double celsius = (fahr3 - 32.0) * (5.0/9.0);
                //@See http://web.cerritos.edu/jwilson/SitePages/java_language_resources/Java_printf_method_quick_reference.pdf
                System.out.printf("|%4d*F     |    % 6.1f*C |%n",      fahr3       ,  celsius  );
                //Increment
                fahr3 += 20;
        } while (fahr3 <= 300); //Check Condition

        System.out.println("|_________________________|");
//</Do-While-Loop>

    }

}
