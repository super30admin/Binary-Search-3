class Solution {
    private double find(double x, int n) {
        // Tc: O(logn) Sc: O(logn)
        if (n == 0)
            return 1;

        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n /= 2;
        }

        if (n < 0) {
            return 1.0 / find(x, -1 * n);
        }

        if (n % 2 == 1) {
            return x * find(x * x, (n - 1) / 2);
        } else {
            return find(x * x, n / 2);
        }
    }

    public double myPow(double x, int n) {
        return find(x, n);

    }

}