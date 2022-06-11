class Solution {
    // Recursion Solution
    // Time complexity is O(logn)
    // Space complexity is O(logn) i.e space of recursive stack else it is O(1)
    // This solution is submitted on leetcode with zero errors
    
    private double result;
    public double myPow(double x, int n) {
        result = 1.000;
        helper(x,n);
        return result;
    }
    
    public void helper(double x, int n){
        // Base case
        if(n == 0) return;
        // Logic
        helper(x,n/2);
        if (n%2 == 0) result = result * result;
        else {
            if(n<0){
                 result = result * result * (1/x);
            } else {
                result = result * result * x;
            }
        }
    }
}