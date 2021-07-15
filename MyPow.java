/**
 * @author Vishal Puri
 * // Time Complexity : O(nk)
 * // Space Complexity : O(k)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class MyPow {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        } else if (n >= 0) {
            return pow1(x, n);
        } else {
            return pow1(1 / x, n);
        }


    }

    public double pow1(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            double a = pow1(x, n / 2);
            return a * a;
        } else {
            double a = pow1(x, n / 2);
            return x * a * a;
        }
    }
}
