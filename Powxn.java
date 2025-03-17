// Time Complexity : O(log n) as its dividing the search space by half.
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        if(n < 0)
        {
            x = 1/x;
            n *= -1;
        }
            
        while(n != 0)
        {
            if(n%2 != 0)
                result *= x;
            x = x*x;
            n = n/2;
        }
        return result;
    }
}