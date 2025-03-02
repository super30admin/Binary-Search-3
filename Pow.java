/*
 * Time Complexity: O(log n)
 * Space Complexity: O(log n) (recursive stack)
 */
public class Pow {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        // calculate x ^ (n/2) recursively
        double halfPow = myPow(x, n/2);
        if(n % 2 == 0) {
            // when n is even it is just x ^ n/2 * x ^ n/2 = x^n
            return halfPow * halfPow;
        } else {
            // when x is odd we have to multiply by a factor of 1/x or x
            // depending on whether n is negative or positive respectively
            if (n < 0) {
                return halfPow * halfPow * 1 / x;
            } else {
                return halfPow * halfPow * x;
            }
        }
    }
}
