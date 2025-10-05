// Time Complexity : O(log2(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        long N=n;
        if(N<0) {
            N=-N;
            x=1/x;
        }
        double ans=1.0;
        while(N>0) {
            if(N%2!=0) ans*=x;
            x*=x;
            N/=2;
        }
        return ans;
    }
}