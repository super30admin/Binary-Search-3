/*
    LC - 50. Pow(x, n)
    TC - O(log n)
    SC - O(log n) recursive stack space
    Approach -
        divide by 2 recursively.
        we know n == 0 then anything power 0 is 1.
        using this base case, get the result and check if the n is even or odd.
        if even, muliply result with the result.
        if odd, multiply result with result and by the x
        if odd and it's negative, then multiply result with result and by the 1/x
*/

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        double result = myPow(x, n / 2);
        if(n % 2 == 0) {
            return result * result;
        } else {
            if(n > 0) { // positive number
                return result * result * x;
            } else {
                return result * result * 1 / x; // for negative scenario (2 ^ -1)
            }
        }
    }
}