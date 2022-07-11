// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//50. Pow(x, n)
//https://leetcode.com/problems/powx-n/

class Solution {
    //time:O(logn)
    //space:O(n) 
    double x1;
    public double myPow(double x, int n) {
        //base
        if(n == 0.000) return 1;
        
        //logic
        x1 = myPow(x, n/2);
        if(n%2 == 0.000){
            return x1*x1;
        }else{
            if(n>0)
                return x1*x1*x;
            else
                return x1*x1*(1/x);
        }
    }
}