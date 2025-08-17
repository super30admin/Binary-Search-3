// TC and SC log(n)
class Solution {
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        double res = myPow(x, n/2);

        if (n % 2 == 0) {
            res = res * res;
        } else {
            if (n < 0) {
                res = res * res * 1/x;
            } else {
                res = res * res * x;
            }
        }
        
        return res;
    }
}