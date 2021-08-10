//time- O(logN)
//space-O(logN)
class Solution {
    public double myPow(double x, int n) {
		// Base
		if (n == 0) {
			return 1.0;
		}
		// Logic
		double prod = myPow(x, n / 2);

		if (n % 2 == 0) {
			// Even
			return prod * prod;
		} else if (n > 0) {
			// Odd and n is positive
			return prod * prod * x;
		} else {
			// Odd and n is negative
			return prod * prod * 1 / x;
		}
    }
}