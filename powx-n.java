// Time Complexity : O(log n)
// Space Complexity : O(log n) if recursive stack is taken into account;
// Did this code successfully run on Leetcode : Yes

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0)
            return 1;
        //logic
        double temp = myPow(x, n/2);
        if(n % 2 == 0)
            temp = temp * temp;
        else{
            if(n > 0)
                temp = temp * temp * x;
            else
                temp = temp * temp * (1/x);
        }
        return temp;
    }
}

