//Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class Power {
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

	public static void main(String[] args) {
		Power obj = new Power();
		int x = 2;
		int n = 10;
		System.out.println("Pow(" + x + ", " + n + ") = " + obj.myPow(x, n));
	}

}
