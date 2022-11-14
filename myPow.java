class Solution {
    public double myPow(double x, int n) {
        
        
        if(n==0)
            return 1;
        
        
        double y=myPow(x,n/2);
        if(n<0)
            if(n%2==0)
                return y*y;
            else 
                return y*y*1/x;
        else
            if(n%2==0)
                return y*y;
            else 
                return x*y*y;
        
        
        
    }
}

// Time Complexity : O(log N)
// Space Complexity : O(log N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
