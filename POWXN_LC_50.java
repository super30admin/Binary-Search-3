/* Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time complexity - O(logN)
Space Complexity - O(logN)
*/

public class POWXN_LC_50 {
    public double myPow(double x, int n) {
        long N = n;
        if (N == 0) {
            return 1.0;
        }
        if (N < 0) {
            return doubleUtil(1/x, -1*N);
        }
        return doubleUtil(x, N);

    }

    public double doubleUtil(double x, long n) {
        double ans = 1;
        double sq = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * sq;
            }
            sq = sq * sq;
            n = n/2;
        }

        return ans;
    }
}
