// Time Complexity : O(logN)
// Space Complexity : O(logN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class PowXN {
    private double prevValue = 1;
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return recursive(x, N);

    }

    private double recursive(double x, long n) {
        //base
        if(n == 0) {
            return 1.0000;
        }

        double result = recursive(x,n/2);
        if(n%2 == 0) {
            return result * result;
        } else {
            if(n < 0) return result * result * (1/x);
            return result * result * x;
        }
    }
}
