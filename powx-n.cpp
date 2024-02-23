// TC = O(logN)
// SC = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    // TC = O(logN), SC = O(1)
    double myPow(double x, int n) {
        // base
        if(n == 0) return 1.00;
        // logic
        double result = myPow(x, n / 2);
        if(n % 2 == 0) return result * result;
        else {
            if(n < 0) return result * result * (1 / x);
            else return result * result * x;
        }
    }
};