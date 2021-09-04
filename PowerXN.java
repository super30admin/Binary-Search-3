//https://leetcode.com/problems/powx-n/
/*
Time: O(logn) 
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class PowerXN {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long m = n; // store a copy of n

        if (m < 0)
            m = m * (-1);

        while (m > 0) {
            if (m % 2 == 1) {
                ans = ans * x;
                m = m - 1; // by this time nn will be 2. So reduce 1.
            }

            else {
                x = x * x;
                m = m / 2;
            }
        }

        if (n < 0)
            ans = (double) (1.0) / (double) (ans);

        return ans;
    }

}
