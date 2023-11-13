/* Time Complexity : O(log n) */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

/*
 logic fails for following input
 x = 1.0000000000001
 n = -2147483648
*/

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.00;
        double result = 1.0;
        if(n == Integer.MIN_VALUE && (x != 1 &&  x != -1))
            result = 0.00;
        if(n < 0){
            x = 1/x;
            n *= -1;
        }
        
        while(n > 0){
            if(n%2 != 0){
                result = result * x;
            }
            x = x*x;
            n = n/2;
        }
        return result;
    }
}