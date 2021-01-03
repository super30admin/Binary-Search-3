/* Implement pow(x, n), which calculates x raised to the power n (i.e. xn). */
/**
* TC O(logn). SC O(logn)
*/
class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n < 0 && n > Integer.MIN_VALUE) {
            n = -1 * n;
            x = 1/x;
        }
        double result = myPow(x, n/2);
        result =n%2 == 0 ? result * result : result * result * x;
        return result;
    }
}
