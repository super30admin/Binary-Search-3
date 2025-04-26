//Time Complexity: O(log n) for the exponentiation
//Space Complexity: O(1) for the result variable
//LeetCode: https://leetcode.com/problems/powx-n/

/**
 * Computes x raised to the power n (x^n) using binary exponentiation.
 * Handles both positive and negative exponents efficiently.
 * Time complexity is O(log n) and space complexity is O(1).
 */

public class Pow {
    public double myPow(double x, int n) {
        double result = 1;

        if(n < 0) {
            x = 1/x;
        }

        while(n != 0) {
            if(n % 2 != 0) {
                result = result * x;
            }
            x = x * x ;
                n = n/ 2;
        }
        return result;
    }
    
}
