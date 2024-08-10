//Time = O(log n)
//Space = O(1)

class Solution {
    public double myPow(double x, int n) {
        // Convert n to a long to handle edge case of n = -2^31
        long N = n;
        // If the exponent is negative, invert both the base and the exponent
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        // Initialize the result to 1
        double result = 1;
        // Iterate over the exponent, halving it each time until it reaches 0
        while (N > 0) {
            // If the exponent is odd, multiply the result by the base
            if (N % 2 == 1) {
                result *= x;
            }
            // Square the base and halve the exponent
            x *= x;
            N /= 2;
        }
        return result;
    }
}
