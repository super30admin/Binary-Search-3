
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Binary Search
 */


class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1;

        if(n<0){
            x=1.0/x;
            n=-1*n;
        }

        double result=1;
        while(n!=0){
            if(n%2==1){
                result=result*x;
                n=n-1;
            }
            x=x*x;
            n=n/2;
        }
        return result;
    }
}