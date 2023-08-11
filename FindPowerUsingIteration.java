package org.example;

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class FindPowerUsingIteration {

    public double myPow(double x, int n) {
        double result = 1.0;

        if(n<0)
        {
            x = 1/x;
        }

        while(n!=0)
        {
            if(n%2 != 0)
            {
                result = result * x;
            }

            x = x*x;
            n = n/2;
        }

        return result;
    }
}
