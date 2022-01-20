// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// approach

// Used Recursion
// calculated result * result if n was even 
// calculated result * result * x if n was odd

class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;

        double result = myPow(x, n / 2);
        if (n % 2 == 0) {
            return result * result;

        } else {
            if (n > 0) {
                return result * result * x;
            } else {

                return result * result * 1 / x;

            }
        }
    }
}