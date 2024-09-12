// Time Complexity :  O(log(n))
// Space Complexity :  O(log(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * log(n) solution achieved by reducing number of calculations by half everytime
 * for negative power - handled it in the odd case
 * https://leetcode.com/problems/powx-n/
 * 
 *
 */
class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0) return 1;
        
        double temp = myPow(x, n /2);
        
        //even power
        if(n%2 == 0){
           return temp * temp;   
        }else { //odd power
             if(n < 0) { //negative power
                return temp * temp * (1 / x);
            } else {
                 return temp * temp * x;
            }
        }
        
    }
}