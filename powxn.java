// Time Complexity : O(log(n))
// Space Complexity : O(n) // recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Divide n/2 untill it equals 0. Return 1.0 if n == 0 as a base case.
 * 2. If n is even, return res * res
 * 3. If n is odd, check if n is negative or positive and return accordingly.
 */

class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        double res = myPow(x, n/2);
        if(n % 2 == 0){
            return res * res;
        }else {
            if(n < 0){
                return res * res * (1/x);
            }else {
                return res * res * x;
            }
        }
    }
}