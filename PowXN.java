// Time Complexity : O(log n) where n is exponent
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Handle negative exponents by taking reciprocal of the base and converting exponent to positive.
//   - Perform iterative fast exponentiation (exponentiation by squaring).
//   - Multiply result by x whenever the current power is odd.
//   - Square x and halve the power at each step.

public class PowXN {
    //recursive TC-O(logn), SC-O(logn)
    // public double myPow(double x, int n) {
    //     if(n == 0) return 1;
    //     double result = myPow(x, n/2);
    //     if(n % 2 == 0) {
    //         return result * result;
    //     } else {
    //         if(n > 0) {
    //             return result * result * x;
    //         } else {
    //             return result * result * 1/x;
    //         }
    //     }
    // }


    //iterative - TC - O(logn), SC - O(1)
    public double myPow(double x, int n) {
        double result = 1.0;
        if(n < 0) {
            x = 1 / x;
            n = n * -1;
        }
        while(n != 0) {
            if(n % 2 != 0) {
                result = result * x;
            }
            x = x * x;
            n = n / 2;
        }

        return result;
    }

    public static void main(String[] args) {
        PowXN solution = new PowXN();
        double x = 2.0;
        int n = 10;
        System.out.println(x + " raised to the power " + n + " is: " + solution.myPow(x, n));
    }
}
