/**LC-50
 * Time Complexity : O(logN) 
 * Space Complexity :
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. 
 
 */
class Solution {
    public double myPow(double x, int n) {
        
        //base
        if(n == 0) return 1;
        
        //logic
        
        double temp = myPow(x, n/2);
        if(n%2 == 0){
            
            return temp*temp;
        }
        else{
            
            if(n<0){
                return temp*temp*(1/x);
            }
            else{
                return temp*temp*x;
            }
        }
        
    }
}