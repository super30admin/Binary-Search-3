// # Binary-Search-3

// ## Problem1 
// Pow(x,n) (https://leetcode.com/problems/powx-n/)

// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE){
            x = x*x;
            n = n/2;
        }
        if(n<0){
            x = 1/x;
            n *= -1;
        }
        double result = 1.00;
        while(n>0){

            // odd case
            if(n%2 != 0){
                result = result*x;
            } 
            x = x*x;
            n = n/2;
        }
        return result;
    }
}