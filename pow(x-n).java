// Time Complexity : O(logn)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1.00000;
        
        double result = myPow(x, n/2);
        
        if(n%2==0){
            return result*result;
        }else{
            if(n>0){
                return result*result*x;
            }
            return result*result*(1/x);
        }
    }
}