//Time Complexity : O(log(n-k)) + O(k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        long N = n;
        if(N < 0) {
            x=1/x;
            N=-N;
        }
        double pow=1, curr = x;

        for(long i=N; i>0; i/=2) {
            if( i%2 == 1) {
                pow=pow*curr;
            }
            curr = curr*curr;
        }
        return pow;
    }

}