
/**
 * Time Complexity: O(logN) where N is the 'n'
 * Space Complexity: O(logN) where N is the 'n'
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None
 *
 * Approach:
 * For n = odd:
 * smallest number * smallest number * x
 * For n = even:
 * smallest number * smallest number
 * For n = negative:
 * smallest number * smallest number * (1/x)
 */
public class PowXN {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return temp * temp * x;
            } else {
                return temp * temp * 1 / x;
            }
        }
    }

    public static void main(String[] args) {
        // Your code here
        PowXN obj = new PowXN();
        double result = obj.myPow(2, 9);
        System.out.println(result);
        assert (result == 512.0);
    }
}
