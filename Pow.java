// Time Complexity : O(log(n))
// Space Complexity : O(log(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Pow {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }

        double returnVal = myPow(x, n/2);

        if( n % 2 == 0){
            return returnVal * returnVal;
        } else {
            if(n > 0){
                return returnVal * returnVal * x;
            } else {
                return returnVal * returnVal * 1/x;
            }
        }

    }
}
