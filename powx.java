// Time Complexity :logn
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes


class Solution {
    public double myPow(double x, int n) {
        // edge
        if (n == 0)
            return 1.0000;
        // logic
        double result = (myPow(x, n / 2));
        if (n % 2 == 0) {
            return result * result;
        } else {
            if (n < 0) {
                return result * result * 1 / x;
            } else {
                return result * result * x;
            }
        }

    }
}