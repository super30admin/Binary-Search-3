// Time Complexity : O(log n) + some constant space(recursion)
// Space Complexity : O(log n) for recursive stack, else O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Basic approach would be to multiply x , n times
//to optimize, we can reduce the size of problem as we are calling repeating sub problems 
//we can reduce the problem to n/2 size and recur further till we reach base case

class Solution {
    public double myPow(double x, int n) {
        if (n==0){
            return 1;
        }
        double val=myPow(x,n/2);
        if(n%2==0){
            return val*val;
        }
        else{
            if(n<0){
                return val*val*1/x;
            }
            else{
                return val*val*x;
            }
        }
    }
}