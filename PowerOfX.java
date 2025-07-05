/*
Time Complexity : O(log N) where N is the absolute value of n.
Space Complexity : O(1) as we are using only a constant amount of space.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Intuition: I used recursion to calculate the power of x raised to n.
*/

//recursive logn solution
public class PowerOfX {
    public double myPow(double x, int n) {
        // base
        if (n == 0)
            return 1;

        // logic
        double res = myPow(x, n / 2);
        if (n < 0) {
            x = 1 / x;
        }

        if (n % 2 == 0) {
            x = res * res;
        } else {
            x = res * res * x;
        }
        return x;
    }
}

// iterative logn solution
class PowerOfXIterative {
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