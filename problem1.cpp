/*
Time complexity: O(log(n))
Space complexity: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
public:
    double myPow(double x, int n) {
        if(n<0)
        {
            x=1/x;
            n = abs(n);
        }
        double res = 1.0;
        while (n!=0) {
            if (n%2!=0) 
                res = res * x;
            x = x * x;
            n /= 2;
        }
        return res;
    }
};