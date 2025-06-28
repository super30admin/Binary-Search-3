/**
 * Leetcode 50. Pow(x, n)
 * Link: https://leetcode.com/problems/powx-n/description/
 */
//------------------------------------ Solution 1 -----------------------------------
public class PowXN {
    /**
     * Iterative solution - Keep on multiplying x with itself basically squaring it while
     * reducing the power n value by half. Whenever we encounter odd n we multiply current x and
     * result. Additionally inverse the x it the beginning if power is negative
     *
     * TC O(logn) SC: O(1)
     */
    public double myPow(double x, int n) {
        double result = 1.0;
        if (n < 0) {
            x = 1/x;
        }

        while(n != 0) {
            if (n%2 != 0) {
                result *= x;
            }
            x = x*x;
            n = n/2;
        }
        return result;
    }
}

//------------------------------------ Solution 2 -----------------------------------
class PowXN2 {
    /**
     * Recursive solution - We want to write a logn solution so we have to reduce the power by half
     * at each recursion and we can do that with squaring the current result at each recursion in case
     * n is even otherwise we have to additionally multiply x as well.
     *
     * TC: O(logn) SC: O(logn)
     */
    public double myPow(double x, int n) {
        //base
        if (n == 0) {
            return 1.0;
        }

        //logic
        double value = myPow(x, n/2);

        if (n < 0) {
            x = 1 / x;
        }

        if (n % 2 != 0) {
            return value * value * x;
        }
        return value * value;
    }
}
