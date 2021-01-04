// Time Complexity : O(logN) N is the power
// Space Complexity : O(logN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0) {
            return 1;
        }
        
        double temp = myPow(x, n/2);
        
        if(n % 2 == 0) {
            return temp * temp;
        }
        else 
        {
            if(n < 0) {
                return temp * temp * 1/x;
            }
            return temp * temp * x;
        }
        
    }
}