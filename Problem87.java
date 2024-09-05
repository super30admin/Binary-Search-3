// Time Complexity: O(log(n))
// Space Complexity: O(log(n))

class Solution {
    public double myPow(double x, int n) {
        // Handle the case where n is negative
        long N = n; // Use a long to avoid overflow when n = Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }
    
    private double power(double x, long n) {
        if (n == 0) {
            return 1.0; // Any number to the power of 0 is 1
        }
        
        double half = power(x, n / 2); // Recursively calculate x^(n/2)
        
        if (n % 2 == 0) {
            return half * half; // If n is even, multiply half by itself
        } else {
            return half * half * x; // If n is odd, multiply by x as well
        }
    }
}
