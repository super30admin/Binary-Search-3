//TimeC:O(logn)
//SC:O(n)
public double myPow(double x, int n) {
        long N = n;         // Convert to long to handle Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;      // Flip base
            N = -N;         // Make exponent positive
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;   // Base case

        double half = fastPow(x, n / 2);  // Recurse

        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }