public class PowerXN {
    public double myPow(double x, int n) {
        return myPowRecursion(x, n);
        return myPowIteration(x, n);
    }

    // TC: O(log n)
    // SC: O(n / 2)
    private double myPowRecursion(double x, int n) {
        if (n == 0) return 1;
        double p = myPowRecursion(x, Math.abs(n / 2));
        p = n % 2 == 0 ? p * p : p * p * x;
        return n > 0 ? p : 1d/p;
    }

    // TC: O(log n)
    // SC: O(1)
    private double myPowIteration(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                res = res * x;
                n = n - 1;
            }
            x = x * x;
            n = n / 2;
        }
        return res;
    }
}
