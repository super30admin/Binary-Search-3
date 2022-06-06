// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, coming up with the right approach
// Your code here along with comments explaining your approach: iteratively use divide and conquer to find powers of x starting from the known power as x^0

public class POW {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = n + 2;
            }
            x = 1 / x;
            n = -n;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return myPow(x * x, n / 2) * x;
        }
    }
}