/****************************************
 *      Lab 5                           *
 *      Samuel Seidel                   *
 *      February 18, 2016               *
 ****************************************/

public class MaxClass {

    public static void main(String[] args) {
        System.out.println( "max(1, 2, 3) = "    + max(1,2,3)    );
        System.out.println( "max(3, 2, 1) = "    + max(3,2,1)    );
        System.out.println( "max(2, 3, 1) = "    + max(2,3,1)    );
        System.out.println( "max(22, 35, 13) = " + max(22,35,13) );
        System.out.println( "max(66, 33, 11) = " + max(66,33,11) );
        System.out.println( "max(10, 10, 8) = "  + max(10,10,8)  );
        System.out.println( "max(10, 10, 12) = " + max(10,10,12) );
    }

    static int max(int x, int y, int z) {
        if (x > y) {
            return x > z ? x : z;
        } else {
            return y > z ? y : z;
        }
    }


}
