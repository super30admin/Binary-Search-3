// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class PowXN {
    public double myPow(double x, int n) {
        // base
        if(n == 0) return 1.00000;
        //logic
        double result = myPow(x, n/2);
        if(n % 2 == 0) {
            return result * result;
        }
        else if(n % 2 != 0) {
            if(n < 0) {
                return result * result * (1/x);
            }
            return result * result * x;
        }
        return result;
    }
}
