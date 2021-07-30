// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return 1/pow(x, -1*n);
                
        return pow(x,n);
    }
    
    public double pow(double x, int n){

        if (n == 0) return 1;
        
        double half = pow(x, n/2);
        
        if (n%2 == 0) return half * half;
        
        else return half *half * x;
    }
}