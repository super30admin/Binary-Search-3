/* Time Complexity : O(logn)
 * Space Complexity : O(h), for recursive stack
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0) return 1.000;
        //logic
        double result = myPow(x, n/2);
        if(n%2 == 0){
           return result * result;
        } else {
            if(n < 0){
               return result * result * (1/x);
            } else {
               return result * result * x; 
            }
        }
    }
}
