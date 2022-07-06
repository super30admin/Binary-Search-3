/**
Time Complexity : O(logN)
Space Complexity : O(D) -> D = depth of the recursion stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{    
    public double myPow(double x, int n) 
    {
        if(n == 0)
            return 1.0000;

        boolean isEvenPower = (n % 2 == 0);

        if(isEvenPower)
        {
            double result = myPow(x, n/2);
            return result*result;
        }
        else
        {
            double result = myPow(x, n/2);
            if(n < 0)
                return (result * result * (1/x));
            else
                return (result * result * x);
        }
    }
} 