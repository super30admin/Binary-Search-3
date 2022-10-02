// Problem1 - https://leetcode.com/problems/powx-n/

// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such


class Solution {
    double result = 0;
    public double myPow(double x, int n) {
        //base
        if(n == 0) return 1.00;
        
        //logic
        double result = myPow(x,n/2);
        
        if(n%2 == 0){
            return result * result;
        }else{
            if(n>0) return result * result * x;
            else return result * result * (1/x);
        }
    }
}