/*
TC --> O(logn)
SC --> O(1)
 */
class Solution {

    public double myPow(double x, int n) {
        double result = Helper(x, Math.abs(n));
        if (n < 0) {
            result = 1 / result;
        }
        return result;
    }

    public double Helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        double res = Helper(x, n / 2);
        res = res * res;
        if (n % 2 != 0) {
            res *= x;
        }

        return res;
    }
}
