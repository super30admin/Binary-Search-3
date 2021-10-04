package BinarySearch3;
// Time Complexity : O(log(n))
// Space Complexity : O(h) - recursion stack
// Did this code successfully run on Leetcode : Yes

public class Mypow {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1.00;
        double result =  myPow(x, n/2);
        if(n % 2 == 0){
            return result* result;
        } else {
            if(n > 0)
                return result*result*x;
            else
                return (result*result* (1/x));
        }
    }

}
