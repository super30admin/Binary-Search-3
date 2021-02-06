/**
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

Time Complexity : O(NlogN)
Space Complexity : O(NlogN)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution
{
    public double myPow(double x, int n) 
    {
         if( n == 0)
            return 1;
            
        if( n == 1)
            return x;
            
        if( n== -1)
            return 1/x;
        
        double result = myPow(x, n/2);
        
        if( n > 0)
        {
            if( n % 2 == 0)
            {
                return result * result;
            }
            else
            {
                return result * result * x;
            }
        } 
        else
        {
            if( n % 2 == 0)
            {
                return result * result;
            }
            else
            {
                return result * result *( 1/x);
            }
        }        
    }
    
}