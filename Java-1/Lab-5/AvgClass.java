/****************************************
 *      Lab 5                           *
 *      Samuel Seidel                   *
 *      February 18, 2016               *
 ****************************************/

public class AvgClass {

    public static void main(String[] args) {
        System.out.println( "avg(0, 0, 1, 0) = "        + avg(0,0,1,0)        );
        System.out.println( "avg(0, 0, 0, 0) = "        + avg(0,0,0,0)        );
        System.out.println( "avg(10, 10, 8, 12) = "     + avg(10,10,8,12)     );
        System.out.println( "avg(-10, -10, -8, -12) = " + avg(-10,-10,-8,-12) );
        System.out.println( "avg(63, 44, 7, 12) = "     + avg(63,44,7,12)     );
        System.out.println( "avg(10, 234, 613, 12) = "  + avg(10,234,613,12)  );
    }

    static double avg(int a, int b, int c, int d) {
        return (a+b+c+d) / (4.0);
    }
}
