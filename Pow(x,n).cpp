// Time Complexity - O(logn) - Is my answer correct?
// Space Complexity - O(1) - Is my answer correct?
// Problems Faced - No!
// It runs on Leetcode.
class Solution {
public:
    double myPow(double x, int n) {
        // base
        if(n == 0)
            return 1.00000;
        
        // logic
        double answer = myPow(x, n/2);
        if(n%2 == 0)
            return answer*answer;
        else if(n < 0)
            return answer*answer*(1/x);
        else
            return answer*answer*x;
    }
};