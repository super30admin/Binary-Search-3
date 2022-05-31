// Time Complexity : O(log n) where n is power
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Solve recursively by computing n/2 power with a base case where n = 0 return 1. Handle the odd and even power scenario.
 */

class Solution {
public:
    double myPow(double x, int n) {
        
        if (n == 0)
            return 1;
        
        double result = myPow(x, n/2);
        
        if (n % 2 == 0)
        {
            return result * result;
        }
        else
        {
            if (n > 0)
            {
                return result * result * x;
            }
            else
            {
                return result * result * 1 / x;
            }
        }
        
    }
};