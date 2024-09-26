// Time Complexity : O(logn)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0)  return 1;
        
        double res = myPow(x, n/2);
        
        if(n % 2 == 0){
            res = res * res;
        }else{
            if(n < 0){
                return res * res * 1/x;
            }
            return res *res * x;
        }
        return res;
    }
}
