// Approach 1: Recursive solution
// Time Complexity : O(logn)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We halve n at each recursion call and consider all cases - n is positive/negative and odd/even

class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1.0;
        if(n%2==0){
            double res = myPow(x,n/2);
            return res*res;
        }
        else{
            if(n>0){
                double res = myPow(x,n/2);
                return res*res*x;
            }
            double res = myPow(x,n/2);
                return res*res*1/x;
        }
    }
}

// Approach 2: Iterative solution
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Same as approach2, but iterative solution so we don't use extra space
// We run a while loop and update the value of both x and n, compare to just n in the recursive solution

class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        if(n<0){
            n = -1*n;
            x = 1/x;
        }
        while(n!=0){
            if(n%2!=0){
                result = result*x;
            }
            x = x*x;
            n = n/2;
        }
        return result;
    }
}
