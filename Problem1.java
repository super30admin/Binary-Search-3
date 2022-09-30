// Time Complexity : O(log(N))
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
/**
 * if the power is even , it is x^n/2 *  x^n/2
 * if the power is odd it is x^n/2 * x^n/2 * x
 */


class Problem1 {
    public double myPow(double x, int n) {

        //base case
        if(n==0) return 1.00;

        double result;
        result = myPow(x,n/2);

        //logic
        if(n%2==0){
            return result * result;
        }
        else{
            //when power is positive
            if(n>0){
                return result*result*x;
            }
            else
                return result*result*(1/x);
        }

    }
}