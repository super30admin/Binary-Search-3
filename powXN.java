
// Time Complexity : O(lonN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double y = myPow(x,n/2);
        if(n%2 == 0)
            return y * y;
        else
            if(n < 0)
                return y * y * 1/x;
            else return y * y * x;
    }
}
