//Time Complexity : O(logn)
//Space Complexity : O(1)


class Solution {
    public double myPow(double x, int n) {
        
        double result = 1.00;
        
        if(n==0)
        {
            return 1;
        }
        
        
        double calc = myPow(x,n/2);
        
        if(n%2==0)
        {
            result = calc * calc;
        }
        else
        {
            if(n>0)
            {
                result = calc*calc*x;
            }
            else
            {
                result = calc*calc*(1/x);
            }
        }
        
        return result;
    }
}