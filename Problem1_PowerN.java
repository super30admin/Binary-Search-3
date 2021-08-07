// Time Complexity : o(logn)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n==0)
            return 1;
        //logic
        double result=myPow(x,n/2);
        
        if(n%2==0) return result*result; //even
        else if(n>0) return result*result*x; // odd and greter than 0
        else  return result*result*1/x;
    }
}