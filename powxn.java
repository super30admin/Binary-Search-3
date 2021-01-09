// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        
        if(N < 0){
            x = 1 / x;
            N = -N;
        }
        
        return fastPow(x , N);       
        
    }
    
    public double fastPow(double x, Long n) {
        
        if(n == 0)
            return 1.0;
        
        double half = fastPow(x, n / 2);
        if(n % 2 == 0)
            return  half * half ;
        else
            return half * half * x;
    }
}
