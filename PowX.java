// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double myPow(double x, int n) {
        // return helperBruteForce(x, n);

        // return helperRecursion(x, n);
        return helper(x, n);
    }

    private double helper(double x, int n) {
        double re = 1.0;

        if(n < 0) {
            x = 1/x;
            n *= -1;
        }

        while(n != 0) {
            System.out.println("n:" + n + "  re: " + re  + "   x: "  + x);
            if(n % 2 != 0) {
                re = re * x;
            }

            x = x * x;
            n /= 2;
        }

        return re;
    }

    private double helperRecursion(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double result = helperRecursion(x, n / 2);
        result *= result;

        if (n < 0) {
            x = 1 / x;
        }
        if (n % 2 != 0) {
            result *= x;
        }

        return result;

    }

    private double helperBruteForce(double x, int n) {
        double result = 1.0;
        x = n < 0 ? 1 / x : n == 0 ? 1 : x;
        for (long i = 0; i < Math.abs((long) n); i++) {
            result *= x;
        }

        return result;
    }
}