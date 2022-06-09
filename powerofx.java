// Time Complexity : O(logn)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
logarithmic recursion of x 

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0) return 1.0000;
        //logic
        
        double result = myPow(x,n/2);
        if(n%2 == 0) return result*result;
        else{
            if(n<0) return result*result*(1/x);
            return result*result*x;
        }
    }
}