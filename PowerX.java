// Time Complexity : O(log N)
// Space Complexity : O(N) recurssion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Recursive approach
class Solution {
    public double myPow(double x, int n) {
        // base case
        if(n==0) return 1;
        if(n==1) return x;
        if(n == -1) return 1/x;

        double result = myPow(x, n/2);

        if(n < 0) {
            x = 1/x;
        }
        if(n % 2 != 0) {
            result = result * result * x;
        }else {
            result = result * result;
        }

        return result;
    }

}
// Iterative Approach
// t = O(log N)
// S = O(1)
class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;

        if(n < 0){
            n = n*-1;
            x = 1/x;
        }

        while( n !=0 ){

            if( n %2 !=0){
                result = result * x;
            }
            x = x * x;
            n = n/2;
        }

        return result;
    }

}