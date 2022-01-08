// Time Complexity : O(log n)
// Space Complexity : O(n) = call stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public double myPow(double x, int n) {
        //base
        if (n == 0) {
            return 1;
        }

        //logic
        double result = myPow(x, n/2);

        // if n is even
        if (n%2 == 0) {
            return result * result;
        }
        // if n is odd
        else {
            // if n is positive
            if (n>0) {
                return result * result * x;
            }
            // if n is negative
            return result * result * 1/x;
        }
    }
}