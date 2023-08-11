package org.example;

// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes

public class FindPowerUsingRecursion {
    double result;
    public double myPow(double x, int n) {

        if(n == 0 )return 1;

        result = myPow(x,n/2);

        if(n<0)
        {
            x = 1/x;
        }

        if(n%2 == 0)
        {
            return result * result;
        }
        else{
            return result *result * x;
        }
    }
}
