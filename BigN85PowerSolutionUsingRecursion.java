//Time complexity is O(logn)
//Space complexity is O(logn)
//This solution is submitted on leetcode

public class BigN85PowerSolutionUsingRecursion {
		public double myPow(double x, int n) {
			// base case
			if (n == 0)
				return 1;
			// logic
			double temp = myPow(x, n / 2);
			if (n % 2 == 0)
				return temp * temp;
			else {
				if (n > 0)
					return temp * temp * x;
				else
					return temp * temp * 1 / x;
			}
		}
	}