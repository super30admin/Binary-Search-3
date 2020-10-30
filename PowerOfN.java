// Time Complexity : O(logN) - As we only perform it  till we reach n/2
// Space Complexity : O(N) - as we use a internal stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double myPow(double x, int n) {
      if(n == 0)
            return 1;
        if(n<0){
            return 1/x * myPow(1/x, -(n + 1));
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
        }
      
}
// Your code here along with comments explaining your approach