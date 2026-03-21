// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to make n iterate by halfing it out in each traversal until it becomes 0 and make x square its ownself.
This way we can achieve the power of x to n in a logarithmic way as we are halfing n out for each computation.
If n is negative, we make it positive and handle x  by doing 1/x.
 */
class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        if(n < 0) {
            x = 1 / x;
            n = n * -1;
        }

        while(n != 0) {
            if(n % 2 != 0)
                result = result * x;
            x = x * x;
            n = n / 2;
        }
        return result;
    }
}