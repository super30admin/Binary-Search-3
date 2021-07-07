/**
Leet Code Submitted : YES
Space Complexity : O(1)
Time Complexity : O(logN)

The idea is to recursively divide the power exponent by 2 till we reach condition where power exponent = 0 or 1. Also, we need to handle negative power case seperately.
**/

class Solution {
    double result;
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        
        result = myPow(x,n/2);
        if(n % 2 == 0){
            result = result * result;
        }else{
            if( n < 0)
                result = result * result * (1/x);
            else
                result = result * result * x;
        }
        
        return result;
    }
}
