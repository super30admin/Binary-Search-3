import java.util.Scanner;

public class XPowerNIterativeBinaryExponentiation {

        //ITERATIVE - BINARY EXPONENTIATION

        public double powerIterate(double x, int n) {

            // if n is negative
            if(n < 0) {

                // reverse decimal of x
                x = 1/x;

                //make n positive
                n *= -1;
            }

            double result = 1.0;

            //until n is zero, iterate
            while(n != 0) {

                // if n is odd, multiply result with an x
                if(n%2 != 0) result *= x;

                // multiply x with itself
                x *= x;

                //2^8 = 256 becomes (2*2)^8/2 = 4^4 = 256

                // half power
                n /= 2;
            }
            // output after while loop i.e., n is zero
            return result;
        }

    public static void main(String[] args) {

        XPowerNIterativeBinaryExponentiation object = new XPowerNIterativeBinaryExponentiation();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        double x = scanner.nextDouble();

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        double answer = object.powerIterate(x, n);

        System.out.println("x raised to the power n is  " + answer);
    }
}

/*
TIME COMPLEXITY = O(log N) - power calculation halved each time
N = power
SPACE COMPLEXITY = O(1) - no stack space
*/
