// Time Complexity : O(logn) as we are diving n by n/2 everytime
// Space Complexity : O(logn) => As are performing recursion n/2 so O(logn) space will be used by recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. In the base condition while checking n ==0 returned 0.0 instead of 1.0

/*
Approach: Recursively call myPow by passing n/2. Then simply check if n%2==0 multiply by result*result, if not then check if n is negative then multiply result*result*1/x else result*result*x
 */
class Solution {
    public double myPow(double x, int n) {

        if(n == 0){
            return 1.0;
        }
        double result = myPow(x, n/2);

        if(n%2 == 0){
            return result*result;
        }
        else{
            if(n >0){
                return result*result*x;
            }
            else{
                return result*result*1/x;
            }
        }

    }
}