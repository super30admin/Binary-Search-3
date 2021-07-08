// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package binarySearch3;

public class Pow {

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1.0;
        }
        double res = myPow(x, n / 2);
        if (n % 2 == 0) {
            return res * res;
        } else {
            if (n < 0) {
                return res * res * 1 / x;
            } else {
                return res * res * x;
            }
        }

    }
}
