//Time Complexity : O(logn)
//Space Complexity : O(1) or stack space

class Solution {
    public double myPow(double x, int n) {

        //base
        if(n==0)
            return 1;

        //logic

        double result = myPow(x, n/2);

        //n is even, positive or negative
        if(n%2 == 0)
            return result*result;
        else //n is odd
        {
            if(n > 0) // n is positive
                return result*result*x;
            else //n is negative
                return result*result*(1/x);
        }
    }
}
