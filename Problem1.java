// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes

// Problem: https://leetcode.com/problems/powx-n/

class Solution {

    public double myPow(double x, int n) {
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        return helper(x, n);
    }

    public double helper(double x, int n){

        if(n == 0){
            return 1;
        }else if(n == 1){
            return x;
        }

        double res = helper(x, n/2);

        if(n % 2 == 0){
            res = res * res;
        }else{
            res = res * res * x;
        }
        return res;
    }
}