// TC: O(log n)
// SC: O(1)
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1.00;
        }
        double res = myPow(x, n/2);
        if(n % 2 == 0) {
            return res * res;
        }
        if(n < 0) {
            return res * res * 1/x;
        } else {
            return res * res * x;
        }
    }
}