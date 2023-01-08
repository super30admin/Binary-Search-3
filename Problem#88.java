// Pow(x, n)

// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public double myPow(double x, int n) {
        if(x == 0)
            return 0.00;
        //base
        if(n == 0)
            return 1.00;
        //logic
        double result = myPow(x, n/2);
        if(n%2 == 0) //even
            return result * result;
        else{ //odd
            if(n < 0) // negative
                return result * result * (1/x);
            else //postive
                return result * result * x;
        }
    }
}