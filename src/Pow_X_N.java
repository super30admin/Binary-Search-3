// Time Complexity : O(log n)
// Space Complexity : O(log n), recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Using Recursive approach The power is divided by 2 every time, the result is reused for odd and even powers
 * if its even, the result is multiplied by itself,
 * if its odd, and the power is positive means, the result is multiplied by itself along with x (given no)
 * if its odd and the power is negative means, the result is multiplied by itself and divided by x (given no) */

public class Pow_X_N {
	public double myPow(double x, int n) {
		//base case
		if(n == 0)
			return 1;
		double result = myPow(x, n/2); // call recursively on n/2 power and store in result each time
		if(n % 2 == 0){    //if power is even
			return result * result;
		}
		else{   // if power is odd
			if(n > 0)   // if n is +ve
				return x * result * result;
			else    // if n is -ve
				return  (result * result) / x;
		}
	}
}
