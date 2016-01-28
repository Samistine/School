/****************************************
 *      Lab 2                           *
 *      Samuel Seidel                   *
 *      January 28, 2016                *
 ****************************************/
public class Calcs {

    public static void main(String[] args) {
        
        //a
        int x1 = 3+4-6/2*3;
        System.out.println("Expression a: x = " + x1);
        
        //b
        int x2 = 12 % 5;
        System.out.println("Expression b: x = " + x2);
        
        //c
        int y3 = 4;
        int z3 = 3;
        int x3 = y3++ + ++z3; 
        System.out.println("Expression c: x = " + x3);
        
        //d
        int x4=3;
        int y4 = x4++ +4;
        System.out.println("Expression d: x = " + x4);
        
        //e
        int y5=7;
        int x5 = (y5<=4)?3:8;
        System.out.println("Expression e: x = " + x5);
        
        //f
        int x6 = 5;
        x6*=3;
        System.out.println("Expression f: x = " + x6);

    }
}
