// 50. Pow(x, n) - https://leetcode.com/problems/powx-n/
// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0) 
            return 1;

        //logic
        double result = myPow(x, n/2);
        if(n%2 == 0) 
            return result * result; // even
        else if(n > 0) 
            return result * result * x; // greater than 0 and odd
        else 
            return result * result * 1/x;
        
    }
}