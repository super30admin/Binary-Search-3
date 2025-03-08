
class Solution {
    public double myPow(double x, int n) {
        long exp = n; // Use long to handle overflow when n = Integer.MIN_VALUE
        
        // If the exponent is negative, invert the base and make the exponent positive
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double result = 1.0;

        // Iterative approach using exponentiation by squaring
        while (exp > 0) {
            if ((exp & 1) == 1) { // If exp is odd, multiply the result by x
                result *= x;
            }
            x *= x; // Square the base
            exp >>= 1; // Divide the exponent by 2
        }

        return result;
    }
}

/*
Time Complexity (TC): O(log n)
- The while loop runs until exp becomes 0.
- The exponent is halved in every iteration (exp >>= 1), resulting in logarithmic time complexity.

Space Complexity (SC): O(1)
- Only a few extra variables (result, exp) are used.
- No additional data structures or recursive calls are needed, leading to constant space usage.
*/
```