/*
**Time Complexity (TC):** O(log N)

**Space Complexity (SC):** O(log N)

Where:
- `N` is the exponent `n`.
*/

class Solution {
public:
    double helper(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        double powerByTwo = helper(x, n/2);
        double fullAns = powerByTwo * powerByTwo;
        if(n % 2 != 0) {
            fullAns *= x;
        }
        return fullAns;
    }
    double myPow(double x, int n) {
        if(n==0) return 1.0;
        double ans = helper(x, n);
        cout <<"ans = " << ans << endl;
        if(n < 0) return 1/ans;
        return ans;
    }
};