// TC -O(logn)
// SC - O(n)

class Solution {
    public double myPow(double x, int n) {
        // Base case: any number raised to the power of 0 is 1
        if(n == 0) return 1.0;

        // Recursive case: compute power of x raised to n/2
        double re = myPow(x, n / 2);

        // If n is even, the result is re^2
        if(n % 2 == 0) return re * re;

        // If n is odd
        else {
            // If n is negative, adjust the result for negative exponent
            if(n < 0) return re * re * 1 / x;    
            // If n is positive, multiply the result by x
            else return re * re * x; 
        }
    }
}