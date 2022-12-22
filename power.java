//TC: O(log n)
//SC: O(1)
//Leetcode : successful
class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1.00;
        double result = myPow(x,n/2);
        if(n%2==0)
            result = result*result;
        else{
            if(n>0)
                result = result*result*x;
            else
                result = result*result*(1/x);
        }
            return result;
    }
}