// the time complexity of this implementation is O(log n)
// space complexity is O(1)
class Power {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double curr = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans *= curr;
            }
            curr *= curr;
        }
        return ans;
    }

        public static void main(String[] args) {
            Power solution = new Power();

            double x = 2.0;
            int n = 10;
            double result = solution.myPow(x, n);
            System.out.println(x + " raised to the power of " + n + " is " + result);

            x = 2.5;
            n = -3;
            result = solution.myPow(x, n);
            System.out.println(x + " raised to the power of " + n + " is " + result);

            x = 0.0;
            n = 5;
            result = solution.myPow(x, n);
            System.out.println(x + " raised to the power of " + n + " is " + result);
        }
}
