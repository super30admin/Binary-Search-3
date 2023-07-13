import java.util.Scanner;

/* Recursively return the result of x raised half the power of parent making recursive call and find the final result*/
public class XPowerNRecursiveBinaryExponentiation {

    //RECURSIVE - BINARY EXPONENTIATION
    public double powerRecurse(double x, int n) {

        //base
        if(n == 0) return 1.0;

        //logic
        double result = powerRecurse(x, n/2);

        // n is even
        if(n%2 == 0) {

             return result*result;
        }
        // n is odd
        else {

            // n is positive and odd
            if(n > 0) return result*result*x;

                // n is negative and odd
            else return result*result*(1/x);
        }
    }

    public static void main(String[] args) {

        XPowerNRecursiveBinaryExponentiation object = new XPowerNRecursiveBinaryExponentiation();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        double x = scanner.nextDouble();

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        double answer = object.powerRecurse(x, n);

        System.out.println("x raised to the power n is  " + answer);
    }
}

/*
TIME COMPLEXITY = O(log N) - problem divided into half each time
SPACE COMPLEXITY = O(log N) - recursive stack space

N = power given
*/