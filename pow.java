// Time Complexity :  O(logn)
// Space Complexity : O(logn) 
// Did this code successfully run on Leetcode : Yes Its working
// Any problem you faced while coding this : No
class Solution {
    public double myPow(double x, int n) {
        double ans = helper(x,n);
        return n >=0 ? ans:1/ans;
    }
    private double helper(double x, int n)
    {
        //base case
        if(n==0.0) return 1.0;
        double p = helper(x,n/2);
        if(n%2!=0) return  p* p * x;
        else return p * p;
    }
}