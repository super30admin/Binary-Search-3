// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class powXN {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1 || n == -1)
            return Math.pow(x, n);        

        double pow = myPow(x, n/2);       
        return pow * pow * ((n%2 == 0) ? 1 : (n < 1) ? 1/x : x);
    }
}