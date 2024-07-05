// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes.Tricky to understand.

/*
 * 
 */

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
50. Pow(x, n)
 * Brute force approach: for loop x for n times O(n)
 * n/2 -> will eventually get to n==1 & n==0 (for sure.) if n is odd collect. if we reduce the n to 1/2 in each iteration,
 * timecomplexity is log(n)
 * Recursive:
 * 
 * 
 * Iterative:
 */

public class PowXn {

    // Recursive

    public double myPow(double x, int n) {
        // base
        if (n == 0)
            return 1;

        double result = myPow(x, n / 2);

        if (n < 0)
            x = 1 / x;

        if (n % 2 != 0) {
            result = result * result * x;
        } else {
            result = result * result;
        }

        return result;
    }

    // Iterative approach
    public double myPow_1(double x, int n) {
        double result = 1.0;

        if (n < 0) {
            x = 1 / x;
            n = n * -1;
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