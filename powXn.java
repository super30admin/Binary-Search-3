// Time Complexity  : O(log n) 
// Space Complexity : O(log n)

// Approach :
// Use recursion to divide the exponent n into smaller subproblems by halving n at each step.
// For odd exponents, multiply the result by x once more.
// For negative exponents, compute the result as 1/x raised to the absolute value of n.

public class powXn 
{
    public double func(long n,double x)
    {
        if(n==1)
        {
            return x;
        }
        else
        {
            double res = func(n/2,x);
            double op = 1;
            if(n%2==1)
            {
                op = x;
            }
            return res*res*op;
        }
    }
    public double myPow(double x, int n) {
        long nn= (long) n;
       if(nn==0)
       {
        return 1;
       }
       if(nn <0)
       { 
            return func(Math.abs(nn),1/x);
       }
       return func(nn,x);
    }
}
    
