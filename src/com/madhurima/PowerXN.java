// Time Complexity : O(LogN) //for pow(2, 6) -> we have powers as 6, 3, 1, 0 so logarithmic
// Space Complexity : O(LogN) //recursion stack
// Did this code successfully run on Leetcode : yes

package com.madhurima;

public class PowerXN {

    //using recursion
    public double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }

        double result = myPow(x, n/2);

        if(n%2 == 0){
            return result * result;
        }else{
            if(n > 0){
                return result * result * x;
            }else{
                return result * result * 1/x;
            }
        }
    }
}
