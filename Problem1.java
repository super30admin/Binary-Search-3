
//Time Complexity: O(log n)
//Space Complexity: O(1)

//We can use binary exponentiation The idea is to divide the exponent by 2 at each step, which reduces the number of 
//multiplications needed. If n is even, we can square the base and halve the exponent. 
//If n is odd, we multiply the result by the base and then proceed as if n were even.
//We also need to handle the case when n is negative by taking the reciprocal of x and making n positive.


class Solution {
    public double myPow(double x, int n) {
        double res=1;
        if(n<0){
            x=1/x;
            n=-n;
        }
        while(n!=0){
            if(n%2!=0)
                res=res*x;
            n=n/2;
            x=x*x;
        }
        return res;
    }
}