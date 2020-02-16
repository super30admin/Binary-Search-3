/*
 * Time complexity : O(log n)
 * Space Complexity : O(log n) considering stack space
 * 
 */
class Solution {
    public double myPow(double x, int n) {
        
        //Base Case
        if(n == 0){
            return 1;
        }
        
        //Logic
        // if(n < 0){
        //     x = 1/x;
        //     n = -(n);
        // }
        
        double result = myPow(x, n/2);
        if(n % 2 == 0){
            result = result * result;
        }else{
            
            if(n < 0)
                result = result * result * 1/x;
            else{
                result = result * result * x;
            }
        }
        
        return result;
        
    }
}