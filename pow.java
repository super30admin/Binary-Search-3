// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA

class Solution {
    private double binaryExp(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -1 * n;
            x = 1.0 / x;
        }
        double result = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                result = result * x;
                n -= 1;
            }
            x = x * x;
            n = n / 2;
        }
        return result;
    }

    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }
}