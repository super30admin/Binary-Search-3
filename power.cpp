// Time Complexity : O(logn); n = index/power
// Space Complexity : O(logn) - height of recursive stack 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Recursive solution. Each call reduces input index by 2.
// 2. Handle odd and even cases separately. Handle negative power in odd case
// 2. Calculate value of function first instead of inside odd and even cases to avoid TLE

class Solution {
public:
    double myPow(double x, int n) {
        double result;
        // base
        if(n==0)
            return 1;
        // logic
        // doesn't work for n=-2147483648 as negation falls out of int range
        // if(n<0)
        //     return myPow(1/x,-n);
        
        result = myPow(x,n/2);
        // odd power
        if(n%2){
            if(n>0)
                return result*result*x;
            else
                return result*result*1/x;
        }
        // even power
        else
            return result*result;
    }
};