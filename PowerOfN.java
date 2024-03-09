// Time complexity: O(log(n))
// Space complexity: O(log(n))

// Approach: Calculate power of n/2; based on if n is even or odd
// adjust the result.

public class PowerOfN {
    public double myPow(double x, int n) {
        double res;

        if (n < 0) {
            res = raisedToPower(x, n * -1);
            return 1 / res;
        } else {
            return raisedToPower(x, n);
        }
    }

    // n >= 0
    public double raisedToPower(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double halfPower = raisedToPower(x, n / 2);

        if (n % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return halfPower * halfPower * x;
        }
    }
}
