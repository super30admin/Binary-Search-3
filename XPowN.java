public class XPowN {

// Time Complexity : O(logN)
// Space Complexity : O(logN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 1: Recursive solution

    class RecursiveSolution {
        public double myPow(double x, int n) {
            if (n == 0){
                return 1.0;
            }
            if (n % 2 == 0) {
                double res = myPow(x, n / 2);
                return res * res;
            } else {
                if (n > 0) {
                    double res = myPow(x, n / 2);
                    return res * res * x;
                }
                double res = myPow(x, n / 2);
                return res * res * 1 / x;
            }
        }
    }

// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 2: Iterative solution

    class IterativeSolution {
        public double myPow(double x, int n) {
            double result = 1.0;
            if (n < 0) {
                n = -1 * n;
                x = 1 / x;
            }
            while (n != 0) {
                if (n % 2 != 0) {
                    result = result * x;
                }
                x = x * x;
                n = n / 2;
            }
            return result;
        }
    }
}
