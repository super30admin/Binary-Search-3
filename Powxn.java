
//Time Complexity: O(log n)
//Space Complexity: O(log n) - recursive stack space 

class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;

        double result = myPow(x, n / 2); // recursive call

        if (n % 2 == 0) {
            return result * result; // for even positive power, no change for even negative power.
        } else {
            if (n > 0) {
                return result * result * x; // for odd positive power
            } else {
                return result * result * 1 / x; // for odd negative power
            }
        }

    }
}