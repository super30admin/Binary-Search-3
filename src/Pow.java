// Time Complexity : O(log N)
// Space Complexity : O(log N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * If n is negative, invert the x value and apply pow function. For pow, we
 * break the n to half every time until n = 0. Once we get the half, if n is
 * even, we multiply half * half else if it is odd, we need to multiply half *
 * half * x.
 *
 */
class Solution {
	public double myPow(double x, int n) {
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}
		return fastPow(x, n);
	}

	public double fastPow(double x, int n) {
		if (n == 0)
			return 1.0;
		double half = fastPow(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		}
		return half * half * x;
	}
}