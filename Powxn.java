/**
 * Time Complexity (TC): O(log n)
 * Space Complexity (SC): O(1)
 */

class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;

        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double current = x;
        double result = 1.0;

        while (N > 0) {
            if (N % 2 != 0) {
                result *= current;
            }
            current = current * current;
            N = N / 2;
        }

        return result;
    }
}
