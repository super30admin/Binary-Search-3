// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    double myPow(double x, int n) {
        //base
        if(n == 0)
            return 1;
        
        //logic
        double y = myPow(x, n/2);
        if(n % 2 == 0)
            return y * y;
        else{
            if(n > 0)
                return y * y * x;
            else
                return y * y * 1/x;
        }
    }
};
