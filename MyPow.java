// Problem 50. Pow(x, n)
// Time Complexity : O(logn)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class MyPow {
    public double myPow(double x, int n) {
        long N = n;
        if (N == 0) {
            return 1;
        }
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return helper(x, N);
    }
    private double helper(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double k = helper(x, n / 2);
        if (n % 2 == 0) {
            return k*k;
        } else {
            return k*k*x;
        }
    }
}
