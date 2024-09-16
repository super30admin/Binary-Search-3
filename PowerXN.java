// Time : O(logn)
// Space: O(n/2) recursion calls

class Solution {
    public double myPow(double x, int n) {
        // case: n < 0
        long N = n;
        if(n < 0) {
        	x = 1 / x; // reci
        	N = -1 * N; // flip
        }

        return power(x, N);
    }

    // helper method
    private double power(double x, long n) {
    	// case: n = 0
    	if(n == 0) return 1;
    	// case: n = 1
    	if(n == 1) return x;

    	double value = power(x, n/2);
    	if(n % 2 == 0) {
    		return value * value;
    	} else {
    		return x * value * value;
    	}
    }
}