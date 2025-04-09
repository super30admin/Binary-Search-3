// TC: O(log N):
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public double myPow(double x, int n) {
    if (n == 0) {
        return 1.0;
    }
    
    // Use a long variable to accommodate potential overflow for negative n.
    long N = n;
    
    // If the exponent is negative, invert x and convert the exponent to positive.
    if (N < 0) {
        x = 1 / x;
        N = -N;
    }
    
    // Initialize the result (pow) as 1.
    double pow = 1;
    // The current product starts as x.
    double cur = x;
    
    // Iterate using exponentiation by squaring.
    // Each iteration, we halve the exponent (i), contributing to an O(log N) time complexity.
    for (long i = N; i > 0; i /= 2) {
        // If the current bit is set (i is odd), multiply the result by cur.
        if ((i % 2) == 1) {
            pow *= cur;
        }
        // Square cur for the next bit.
        cur *= cur;
    }
    
    return pow;
}
