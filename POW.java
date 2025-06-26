// Time Complexity O(log n)
// Space Complexity O(h) h = hight of recursive stack
// Runs on LeetcCode Yes
class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;

        if (n == 0) {
            return result;
        }
        result = myPow(x, n / 2);
        if (n < 0) {
            x = 1 / x;
        }
        if (n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }
}