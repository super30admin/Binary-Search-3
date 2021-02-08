// Time Complexity : O(log(n))
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Pow {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }

        //logic

        double temp = myPow(x, n/2);
        //if even power
        if(n % 2 == 0){
            return temp * temp;
        }
        //if odd or negative
        else{
            //if neg
            if(n < 0){
                return temp * temp * (1/x);
            }
            else{
                return temp * temp * x;
            }
        }
    }
}