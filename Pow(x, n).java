// Time Complexity : O(log n) --> where n is the input power
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (50): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public double myPow(double x, int n) {
        // base case
        if (n == 0) return 1;
        
        // logic
        double temp = myPow(x, n/2);
        if (n % 2 == 0) return temp * temp; // even case
        else { // odd case
            if (n < 0) return temp * temp * (1/x);
            else return temp * temp * x;
        }
    }
}