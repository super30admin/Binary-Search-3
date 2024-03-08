// TC - O(log N)
// SC - O(1)

public class PowIterative {
    class Solution {
        public double myPow(double x, int n) {
            double result = 1.0;

            if (n < 0) {
                // n = n * (-1); //Module handles negative values
                x = 1 / x;
            }

            while (n != 0) { // n>0 fails for -2147483648 if n is changed to positive -> No such positive value
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
