//Time : O(logN)
//Space: O(1)

public class PowNX {
	public double myPow(double x, int n) {
		// base
		if (n == 0)
			return 1.0;

		double result = myPow(x, n / 2);

		if (n % 2 == 0) {
			return result * result;
		} else {
			if (n > 0) {
				return x * result * result;
			} else {
				return 1 / x * result * result;
			}
		}

	}
}
