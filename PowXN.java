
// Time Complexity : O(n) where n is the input parameter.
// Space Complexity : O(1) as we are using constant space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can use the concept of fast exponentiation to calculate the power of a number in logarithmic time.
// We will keep multiplying the base with itself and dividing the power by 2 until the power becomes 0.
//  If the power is odd, we will multiply the result with the base.
// For negative powers, we will take the reciprocal of the base and make the power positive.
// This approach ensures that we are calculating the power in O(log n) time complexity.

class Solution {
    public double myPow(double x, int n) {

        long power = n;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1.0;

        while (power != 0) {

            if (power % 2 != 0) {
                result *= x;
            }

            x *= x;
            power /= 2;
        }

        return result;
    }
}