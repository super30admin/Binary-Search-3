//Time complexity: O(logn)
//Space Complexity: O(n/2) //recursive calls

class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0 || x == 0)
            return 1;
        
        //if our (-2)^31 ==> if change it to positive which is (2)^31 goes out of index
        //coz int range is [−2^31, 2^31 − 1]
        long N = n;
        
       //if power is negative
       if(n < 0)
       {
           x = (1/x); //take the reciprocal
           N = (-1 * N); // convert it into positive
       }
        
        return power(x, N);
        
    }
    
    
    private double power(double x, long n)
    {
        if(n == 1)
            return x;
        
        if(n == 0)
            return 1;

        double val = power(x, n/2);
        if(n%2==0)
            return val * val;
        else
            return x * val * val;
 
    }
}
