/**LC-50
 * Time Complexity : O(logN) 
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 Here we reduce the search space by half by reducing value of N into a half each time.
 We continue this till n becomes 0. 
 Gist: 
 Even N: eg 3^6 = 3^3 * 3^3
 Odd N: 3^ 7 = 3^3 * 3^3 * 3
 In case of negative, in Odd, we do (1/3)
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