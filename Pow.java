// Time Complexity : O(logn)
// Space Complexity : O(1)
// Method used : Binary Search

class Solution {
    public double myPow(double x, int n) {
        
        double ans = 1.0;

        if(n < 0)
        {
            n = -n;
            x = 1 / x;
        }

        while(n != 0)
        {
            if(n % 2 != 0) ans = ans * x;
            
            x = x * x;
            n /= 2;
        }

        return ans;
    }
}