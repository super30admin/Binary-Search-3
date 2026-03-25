// Iterative O(log n) time, O(1) space
class Solution {
    public double myPow(double x, int n) {
        
        double ans = 1.0;

        if (n < 0) {
            x = 1 / x;
        }

        while (n != 0) {
            if (n % 2 != 0) {
                ans = ans * x;
            }
            n = n / 2;
            x = x * x;
        }
        return ans;
    }
}