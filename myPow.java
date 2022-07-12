// Time Complexity : O(logn)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public double myPow(double x, int n) {
        double result;
        if(n==0){
            return 1;
        }
        result = myPow(x,n/2);
        if(n%2 == 0){
            result = result*result;
        }
        else{
            if(n>0){
                result = result*result*x;
            }
            else{
                result = result*result* (1/x);
            }
        }
        return result;
    }
}