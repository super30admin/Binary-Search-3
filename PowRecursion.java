// TC - O(log N)
// SC - O(log N) => ?

public class PowRecursion {
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }

            double result = myPow(x, n / 2);
            result = result * result;
            if (n % 2 != 0) {
                if (n < 0) {
                    x = 1 / x;
                }
                result = result * x;
            }

            return result;
        }
    }
}
