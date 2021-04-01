// Time Complexity : O(log n)
// Space Complexity : O(log n) since using recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double res = 1;
        if(n < 0)
            return n%2 ==0 ? myPow(1/x*1/x,-(n/2)) : myPow(1/x*1/x,-(n/2)) *1/x;
        return n%2 == 0 ? myPow(x*x,n/2) : myPow(x*x,n/2)*x;
    }
}
