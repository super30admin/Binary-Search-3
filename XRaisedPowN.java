//Approach 1 - recursion
public class XRaisedPowN {
    public double myPow(double x, int n) {

        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n == -1)
            return 1 / x;

        double res = myPow(x, n / 2);

        if (n % 2 == 0) {
            return res * res;
        } else {
            if (n > 0)
                return res * res * x;
            else
                return res * res * 1 / x;
        }

    }
}
//TC: O(log n), SC: O(log n)

//Approach - 2 - Iterative
class Solution {
    public double myPow(double x, int n) {

        double res = 1.0;

        if (n < 0) {
            x = 1 / x;
        }

        while (n != 0) {
            if (n % 2 != 0) {
                res = res * x;
            }

            x = x * x;
            n = n / 2;
        }

        return res;
    }
}

//TC: O(log n), SC: O(1)