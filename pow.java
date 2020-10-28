/*
Time Complexity: O(logn)
Space Complexity: O(logn)
*/

class Solution {

    public double power_Util(double x, long n)
    {
        if(n == 0) return 1;
        if(n == 1)return x;
        if(n<0)
        {
            return power_Util(1/x,-n);
        }
        double result = power_Util(x*x, n/2);
        if(n%2 != 0)
        {
            result*=x;
        }
        return result;

    }

    public double myPow(double x, int n) {

       return power_Util(x, new Long(n));
    }
}
