// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double result = myPow(x, n / 2); // power / 2 -> recursion
        if (n % 2 == 0) { // even power
            return result * result;
        } else {
            if (n > 0) { // positive odd
                return result * result * x;
            } else { // negative odd
                return result * result * 1 / x;
            }
        }
    }
}