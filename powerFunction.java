// Time Complexity : O(lgn)
// Space Complexity : O(lgn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class powerFunction {
    public double myPow(double x, int n) {
        // base case
        if (n == 0) return 1;
        // logic
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;    
        } else {
            if (n > 0) {
                return half * half * x;
            }
            else return half * half * (1/x);
        }
    }
}