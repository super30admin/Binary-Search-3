//TC - O(log(n))
//SC - O(log(n))

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        
        if(n < 0)
        {
            N = -n;
            x = 1 / x;
        }
        
        if(N >= recurse(2,31) - 1 && x != 1.0 && x != -1.0) return 0.0;
        if(N <= recurse(-2,31) && x != 1.0 && x != -1.0) return 0.0;
        
        return recurse(x, N);
    }
    
    private double recurse(double x, long n)
    {
        //base
        if(n <= 1) 
        {
            if(n == 1) return x;
            else return 1.0;
        }
        
        //logic
        double temp = recurse(x , n / 2);
        if(n % 2 == 0)
        {
            return temp * temp;
        }
        else
        {
            return temp * temp * x;
        }
    }
}
