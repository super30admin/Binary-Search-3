// Time Complexity : O(log n) because the exponent is divided by 2 in every iteration
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use Binary Exponentiation to efficiently calculate powers by repeatedly squaring the base.
// If the current exponent is odd, we multiply the current result with the base before reducing the exponent.
// For negative powers, we invert the base first and then process the exponent as a positive number.

class Solution {

    public double myPow(double x, int n) {

        double result = 1.0;

        // handle negative exponent
        if (n < 0) {

            x = 1 / x;

            n = n * -1;
        }

        while (n != 0) {

            // current power contributes to answer
            if (n % 2 != 0) {

                result = result * x;
            }

            // square the base
            x = x * x;

            // reduce exponent
            n = n / 2;
        }

        return result;
    }
}
