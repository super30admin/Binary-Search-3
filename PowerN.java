
// Time: O(logn)
// Space: O(1)
// Ran successfully on leetcode: yes
class Solution {
    public double myPow(double x, int n) {

        double ans = 1;

        if (n < 0) {
            x = 1 / x;
            n = Math.abs(n);;
        }

        while (n != 0) {
            if (n % 2 != 0) {
                ans = ans * x;
            }
            x = x * x;
            n = n / 2;
        }
        return ans;
    }
}