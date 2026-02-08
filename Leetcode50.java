class Solution {
    public double myPow(double x, int n) {
        // Solution
        // TC - O(logn)
        // SC - O(1)
        double res = 1.0;
        if (n < 0)
            x = 1 / x;
        while (n != 0) {
            if (n % 2 != 0) {
                res = res * x;
            }
            x = x * x;
            n = n / 2;
        }
        return res;

    }
}