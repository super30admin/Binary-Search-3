// Time Complexity : O(n/2) .
// Space Complexity : O(n/2) for Recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Recursive solution.

class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 1;
        return pow(x, n);
    }
    public double pow (double x, int n) {
        if(n == 0) return 1;

        double temp = pow(x, n/2);
        if(n % 2 == 0)
            return temp * temp;
        else
        {
            if(n < 0) {
                return temp * temp * (1/x);
            } else {
                return temp * temp * x;
            }
        }
    }
}
