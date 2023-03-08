// TC: O(log n)
// SC: O(1)
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        long N = n;
        if(N < 0) {
            x = 1 / x;
            N = N * -1;
        }
        return helper(x, N);
    }
    private double helper(double x, long n) {
        if(n == 0) {
            return 1.0;
        }
        double half = helper(x, n / 2);
        if(n % 2 == 0) {
            return half * half;
        }
        return half * half * x;
    }
}