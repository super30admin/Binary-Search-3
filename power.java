// Time Complexity : O(N) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Divide by 2 in each recursive step
*/


// Your code here along with comments explaining your approach
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.00;
        double answer = myPow(x, n/2);
        if(n%2 == 0) {
            return answer * answer;
        } else {
            if(n<0) {
                return answer * answer * (1/x);
            } else {
                return answer * answer * x;
            }
        }
    }
}
