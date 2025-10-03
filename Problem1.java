// Time Complexity : O(logn)
// Space Complexity : O(logn) for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We use recursion to divide the exponent ie n into half for each recursion
// We then check if n is even or odd
//if n is even then we divide into two halves
//if n is off we divide into halves and multiply by x
//We also handle edge case when n is negative when we check for n is odd ie when n is positive odd we just multiply by x and when n is negative odd we need to multiply it by 1/x
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        double half = myPow(x, n/2);
        if(n % 2 == 0) {
            //n is even
            return half * half;
        } else {
            //n is odd
            if(n > 0) {
                return half * half * x;
            } else {
                return half * half * 1/x;
            }
        }
        
    }
}
