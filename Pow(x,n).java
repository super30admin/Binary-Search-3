// Time Complexity : O(logN) where N = given power n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//50. Pow(x, n) (Medium) - https://leetcode.com/problems/powx-n/
class Solution {
    public double myPow(double x, int n) {
        // base
        if (n == 0) return 1.0;
        
        // logic
        double result = myPow(x, n/2);
        if (n%2 == 0) {
            return result * result;
        } else {
            if (n > 0) {
                return result * result * x;
            } else {
                return result * result * (1/x);
            }
        }
    }
}