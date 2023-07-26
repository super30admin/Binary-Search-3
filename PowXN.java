// Time Complexity : O(log(n))
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        double ans = myPow(x, n / 2);
        if (n % 2 == 0) {
            return ans * ans;
        } else {
            if (n < 0) {
                return ans * ans / x;
            } else {
                return ans * ans * x;
            }
        }
    }
}