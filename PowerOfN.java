// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// if n is negative, make x as 1/x
// if n is odd, multiply with x additionally 
// 2^7 = 2^3 * 2^3 *2

class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
        }
        return helper(x,n);
    }

    public double helper(double x,int n){
        if(n==0)
            return 1.0;
        
        double re = helper(x, n/2);
        if(n%2!=0)
            re = re* re* x;
        else
            re = re* re;
        
        return re;
    }

    public double myPowWhile(double x, int n) {
        if(n<0){
            x=1/x;
            n*=-1;
        }

        double tmp = x; // tmp calculates even powers simultaneously
        double re = 1;
        while(n!=0){
            if(n%2!=0)
                re = re*tmp;
            tmp *= tmp;
            n =n/2;
        }

        return re;
    }
}