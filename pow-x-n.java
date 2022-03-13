//Time complexity: o(logn)
//space complexity:0(log n )
//calculating half everytime.

class Solution {
    double res = 0;
    public double myPow(double x, int n) {
        return helper(x, n);
    }
    
    private double helper(double x, int n)
    {
        //base
        if(n==0)
        {
            return 1.00;
        }
        
        
        double sum = 0;
        sum = helper(x, n/2);
        //recurse
        if(n%2 == 0)
        {
            
            res = sum*sum;
        }
        else{
            if(n>0)
            {
                res = sum*sum *x;
            }
            else{
                res = sum*sum*(1/x);
            }
        }
        return res;
    }
    
    
}