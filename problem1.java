// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :yes

/*
 * Approach
 * 
 * We are using recrusion to
 * to solve this
 * 
 * every recursion call we half the n
 * 
 * if n modlus  2 is 0 we return re*re
 * else (when num is odd) if it is negative we do re*re*1/x or re*re*x
 */
class Solution {
    public double myPow(double x, int n) {
        // base
        if (n == 0)
            return 1.0;

        // logic
        double re = myPow(x, n / 2);
        if (n % 2 == 0) {
            return re * re;
        } else {
            if (n < 0) {
                return re * re * 1 / x;
            } else {
                return re * re * x;
            }
        }

    }
}