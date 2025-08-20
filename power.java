//Time Complexity: O(log |n|).
//Space Complexity: O(1).

//If n < 0, invert the base (x = 1/x) and work with a nonnegative exponent e = -n (use long to avoid overflow).
//Initialize result = 1; while e > 0, if e is odd, multiply result *= x.
//Square the base each step (x *= x) and halve the exponent (e >>= 1); return result.

class Solution {
    public double myPow(double x, int n) {

        double result = 1.0;

        if (n < 0) {
            x = 1 / x;
            n = n * -1;
        }

        while (n != 0) {

            if (n % 2 != 0) {
                result = result * x;
            }

            x = x * x;
            n = n / 2;
        }

        return result;
    }
}
