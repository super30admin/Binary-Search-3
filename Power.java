/*
Time Complexity: O(log(n)), here n is the given power
Space Complexity: O(log(n)), n is the given power and this space is space for recursion tree
Run on leetcode: yes
Any difficulties: no
Approach:
1. Divide and conquer approach, calculating result for half of the power and then using that to produce result for actual
power
2. Another case is of negative power, so when the power is negative I would be using 1/number as my number for calculations
(basic mathematics)
 */

class Solution {
    public double myPow(double x, int n) {
        //TC: O(logN)
        //SC: O(logN)

        if(n<0)
        {
            x= 1/x;

        }
        return myPowRec(x, n);



    }


    private double myPowRec(double x, int n)
    {
        //base
        if(n==0)
        {
            return 1;
        }
        //rec
        double res = myPowRec(x, n/2);

        if(n%2 == 0){
            return res*res;
        }

        return res*res*x;
    }
}