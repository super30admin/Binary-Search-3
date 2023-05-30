// Time Complexity : O(log(n))
// Space Complexity : O(log(n)) for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We use a binary split approach to solving this problem.
 * We take advantage of the property of powers where even powers can be split
 * into 2 and multiplied, and odd powers can be split into 2, then multiplied
 * then multiplied again with the root. This way, we split the problems until
 * base case is achieved.
 */

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        double result = myPow(x, n/2);
        if(n % 2 == 0) { // even power
            return result * result;
        } else { // odd power
            if(n >= 0) {
                return result * result * x;
            } else {
                return result * result * 1/x;
            }
        }
    }
}