//Time Complexity : O(log Y) wher Y = power for given number 

//Space Complexity : O(1) for all operations
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
 
*/
public class PowerFunc {

	double power(double num, int power) {
		double res = 1;
		if (power < 0) {
			num = 1 / num;
			power = -power;
		}
		while (power > 0) {
			if (power % 2 == 1) {
				res = res * num;
			}
			num = num * num;
			power = power / 2;
		}
		return res;
	}

	public static void main(String args[]) {
		PowerFunc power = new PowerFunc();

		System.out.println(power.power(2.00, 10));
		System.out.println(power.power(2.1, 3));
		System.out.println(power.power(2.000, -4));
	}
}
