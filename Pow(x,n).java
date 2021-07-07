class Solution {
        // Time Complexity : O(N)  N: power value
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : TLE
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Bruteforce  
 */
    public double myPow(double x, int n) {
        double result = 1;
        for(int i =0;i<Math.abs(n);i++){
                if(n<0){
                    result = (result)*(1/x);
                }
                else{
                    result = (result)*(x);
                }
                
        }
        
        return result;
    }
}




class Solution {
        // Time Complexity : O(logN)  N: power value
// Space Complexity : O(logN)  recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Idea is that even power just takes square of half power and odd power needs extra base value multiplied. 
 */
    public double myPow(double x, int n) {
        //base
        if(n==0){
            return 1;
        }
        //logic
        double result = myPow(x,n/2);
        if(n%2 == 0){
            return result*result;
        }
        else{
            if(n<0){
                return result*result*(1/x);
            }
            else{
                return result*result*x;
            }
        }
    }
}