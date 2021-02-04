// Time Complexity : O(logn)
// Space Complexity :O(1) heap space, O(logn) stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// by taking square of num at any stage reduces power required by 2. take care of odd powers by multiplying again

class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return x;
        if(n == 0) return 1;
        return calc(x,n,1);
    }
    public double calc(double x, int n, double rem){
        if(n == 1) return x*rem;
        if(n == -1) return 1/(x*rem);
        if(n % 2 != 0) rem *= x;
        return calc(x*x,n/2, rem);
    }
}