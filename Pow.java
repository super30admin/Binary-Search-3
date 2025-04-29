// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Pow {
    public double myPow(double x, int n) {
        if(n==0) {
            return 1.0;
        }

        if(n<0) {
            if(n==Integer.MIN_VALUE) {
                n+=2;
            }
            x=1/x;
            n=-n;
        }
        return (n%2==0)? myPow(x*x,n/2):x*myPow(x*x,n/2);
    }
}
