// Time Complexity : O(log n)
// Space Complexity : O(n) - recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Pow(x,n)

class Solution {
public:
    double myPow(double x, int n) {
        
        if(x == 0)
            return 0;
        
        if(n == 1)
            return x;
        
        if(n == -1)
            return 1.0/x;
        
        if(n == 0)
            return 1;
        
        int m = n/2;
        
        if(n % 2){
            if(n>0)
                return x*myPow(x*x,m);
            else
                return (1.0/x)*myPow(x*x,m);
        }
        else
            return myPow(x*x,m);
    }
};