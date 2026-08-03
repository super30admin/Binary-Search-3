class Solution {
    /*  
        TC - O(log n)
        SC - O(1)
        While n is not 0:
        If n is odd, multiply the current base x into result.
        Square the base to represent the next power.
        Halve the exponent (n = n / 2) because each squaring accounts for two multiplications.
        By halving the exponent in every iteration, the algorithm requires only log(n) iterations
         instead of n multiplications.

    */
    public double myPow(double x, int n) {
        double result = 1.0;
        if (n < 0) {
            x = 1/x;
        }

        while (n != 0) {
            if (n % 2 != 0) {
                result = result * x;
            }
            x = x * x;
            n = n/2;
        }

        return result;
    }
}