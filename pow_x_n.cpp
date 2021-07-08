// Time Complexity : O(logn)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
private:
    double helper_rec(double x, int n)
    {
        if(n == 0)
            return 1.0;
        
        if(n == 1)
            return x;
        
        double ret_val;
        
        int n1 = int(floor(double(n)/2));
        int n2 = int(ceil(double(n)/2));
        
        if(n1 != n2)
            ret_val = helper_rec(x,n1) * helper_rec(x,n2);
        else
            ret_val = helper_rec(x,n1) * helper_rec(x,n1);
        
        return ret_val;
    }
    
public:
    double myPow(double x, int n) {
        
        if(n < 0)
            x = 1 / x;
        
        return helper_rec(x, abs(n));
    }
};