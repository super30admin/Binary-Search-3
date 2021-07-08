public class PowerXN {
    /*
    TC : O(logn) as search space is reduced into half everytime
    SC : O(logn) for the recursive stack
    Leetcode : yes
    Problems : No
     */

    /**
     * Here we divide n by 2 everytime and find x^ n/2 and multiple it with itself instead of calculating x^n
     *
     * @param x
     * @param n
     * @return
     */
    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return fastPow(x, n);
    }
}
