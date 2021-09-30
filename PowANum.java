/**
 * Time complexity is O(log(n)). The number is being halved for every call
 * .Space complexity if we take recursive stack intoconsideration then log(n)
 * Else O(1)
 */

class PowANum {
    public double myPow(double x, int n) {

        if (n == 0)
            return 1;
        double result = myPow(x, n / 2);
        if (n % 2 == 0)
            return result * result;
        else {
            if (n < 0)
                return result * result * (1 / x);
            else
                return result * result * x;
        }
    }
}