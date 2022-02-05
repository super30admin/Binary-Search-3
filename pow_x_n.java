// Time Complexity : Add : O(log(n)
// Space Complexity : O(log(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Pow_x_n {
    public static void main(String[] args) {
        myPow(2.00, 8);
    }

    public static double myPow(double x, int n) {
        if(n == 0)
            return 1.00;

        double result = myPow(x, n/2);

        if(n%2 == 0){
            return result * result;
        } else {
            if(n>0)
                return result*result*x;
            else
                return result*result*(1/x);
        }
    }
}

