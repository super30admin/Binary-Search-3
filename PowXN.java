// Time Complexity : O(log N) // every time we are processing half
// Space Complexity :O(log N) //stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * 1. when x pow 0 return 1
 * 2. call iterator with n/2.
 * 3. if it is odd need to consider missing index so if positive *x or *1/x
 */

public class PowXN {
	public double myPow(double x, int n) {

		// base
		if (n == 0)
			return 1;

		double result = myPow(x, n / 2);
		if (n % 2 == 0) {
			return result * result;
		} else {
			if (n > 0) {
				return result * result * x;
			} else {
				return result * result * 1 / x;
			}

		}

	}
}
