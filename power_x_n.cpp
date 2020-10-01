// Time Complexity : O(log(n))
// Space Complexity : O(log(n)) with the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning




class Solution {
public:
    double myPow(double x, int n) {
        
        if(n <0)
            x = 1/x;
        
       return recursion(x,n);
        
    }
    
    
    double recursion(double x, int n){
        
        if(n == 0)
            return 1;
        double res = recursion(x,n/2); 
        
        if(n%2 ==0){
            
            return res*res;
        }else if (n%2 != 0){
            return res*res*x;
            
        }
        return 0;
    }
};