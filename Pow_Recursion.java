//TimeComplexity ::: o(log n) as the n is reduced to half everytime
//SpaceComplexity ::: o(log n) as in the recursion stack, everytime we store the n/2 times the result
//Did this worked successfully in leetcode :: yes

class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;

        // In this reursion, the base case would be when n to the power of zero which
        // returns 1
        // and every time we call resursion, we reduce the pwoer to half
        // if the power is even after halving, then do the result * result
        // if the power is odd and positive, we'll do result * result * x
        // if the power is odd and negative, we'll do result * result * 1/x

        double result = myPow(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            if (n > 0) {
                return result * result * x;
            } else {
                return result * result * 1 / x;
            }
        }

        // Example::
        // 2^6 = 2^3 * 2^3
        // 2^3 = 2^1 * 2^1 * 2
        // 2^1 = 2^0 * 2^0 * 2

        // Example::
        // 3^-4 = 3^-2 * 3^-2
        // 3^-2 = 3^-1 * 3^-1 * 3
        // 3^-1 = 3^0 * 3^0 * 1/3

    }
}