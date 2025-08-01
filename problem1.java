// Time Complexity : O(log(n))
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I used binary approach - reducing search space by half. If the power is even, i divide it by 2 by squaring the current number, if it is not, I just multiply it once and reduce n by 1, i store this in result.

class Solution {
    public double myPow(double x, int n) {
        if(x==1) return 1;
        if(x==-1 && n%2==0) return 1;
        if(n==Integer.MIN_VALUE) return 0;
        if(n<0){
            x=1/x;
            n*=-1; 
        }
        double res = 1;
        while(n>0){
            if(n%2==1){
                res*=x;
                n--;
            }
            x*=x;
            n/=2;
        }
        return res;
    }
}