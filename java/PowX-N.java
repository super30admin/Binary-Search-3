// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Time Limit Exceeded
// Any problem you faced while coding this : No

class Solution {
    public double myPow(double x, int n) {
        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double ans = 1;
        for (long i = 0; i < power; i++) {
            ans = ans * x;
        }
        return ans;
    }
}