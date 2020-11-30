// Time Complexity : o(logn)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no (TLE)
// Leetcode : 50
//Approach: recursion

class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0)
            return 1;
        
        double res = 1;
        if(n > 0){
             res = x* myPow(x,n-1); 
        }
        
        if(n<0){
            res = (1/x)*myPow(x,n+1);
        }
        
        return res;
    }
}

// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 
// Leetcode : 50
//Approach: divide and conquer


class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0)
            return 1;
        
        double val = myPow(x, n/2);
        if(n %2 ==0){
             return val*val;
        }
        else{
            if(n<0){
                return val*val*(1/x);
            }
            else{
                return val*val*x;
            }
        }
    }
}