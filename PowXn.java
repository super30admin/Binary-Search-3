// Time Complexity : O(logn) where n==x
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Use recursion to solve the problem,
base case--> if n==0 return 1
then  find value of n/2 at each point,
if n is even then return half*half
if n is odd return half*half*x
*/
public class PowXn {
    public double myPow(double x, int n) {
        if(x==0) return 0.0;
        if(n==0) return 1.0;

        if(n<0){
            n*=-1;
            x=1/x;
        }

        return pow(x,n);
    }

    private double pow(double x,int n){

        if(n==0) return 1.0;

        double half= pow(x,n/2);
        if(n%2==0){
            return half*half;
        }else{
            //odd
            return half*half*x;
        }
    }
}
