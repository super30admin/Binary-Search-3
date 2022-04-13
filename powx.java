// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public double myPow(double x, int n) {
        //base
        if(n==0)return 1.00;
        double result = myPow(x,n/2);
        //even
        if(n%2==0){
            return result * result;
        }else{
            if(n>0){
                return result*result*x;
            }else{
                return result*result*(1/x);
            }
        }
    }
}