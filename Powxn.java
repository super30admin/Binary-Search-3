// Time Complexity : O(log n) Binary Search where n is the number
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Divide the number's power by 2 each time and do the product of the result, if
the power is odd, check if the power is positive, then multiply the product got till now with the number x else if the number is negative, multiply
the product with reciprocal of x.
*/
class Solution {
    public double myPow(double x, int n) {
        if(n == 0){return 1;}
        double res = myPow(x, n/2) ;                                            // Divide the power by half
        if(n % 2 == 0){
           res *= res;                                                          // power is even 
        } else {                                                            // Power is odd
            if(n > 0){
            res *= res * x;                                                         // Positive power 
            } else {
            res *= res * (1/x);                                                         // Negative power
            }
        }
        return res;
    }
}