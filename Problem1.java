// Time Complexity : O(log n) where n is int n of input
// Space Complexity : O(log n) recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }

        double result = myPow(x, n/2);
        if(n % 2 == 0){
            return result * result;
        }else{
            if(n > 0){
                return result * result * x;
            }else{
                return result * result * 1 / x;
            }
        }
    }

}
