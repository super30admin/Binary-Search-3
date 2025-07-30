// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : keep multiplying x with itself log n times if even. Multiply with x once more if odd
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        if(n<0){
            x = 1/x;
        }
        while(n!=0){
            if(n%2!=0){
                res = res * x;
            }
            x = x*x;
            n = n/2;
        }
        return res;
    }
}