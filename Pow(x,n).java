// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
// Approach:
// Keep dividing the power n by 2 and solve recursively.
// If n is even, return result * result; if odd, multiply with x or 1/x if negative.


class Solution {
    public double myPow(double x, int n) {
        
        if(n==0) return 1;

        double result=myPow(x,n/2);

        if(n%2==0){
            return result*result;
        }
        else{
            if(n>0){
                return result*result*x;
            }
            else{
                return result*result*(1/x);
            }
            
        }
    }
}



// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Approach:
// If the power is negative, convert it to positive and make x as 1/x.
// Keep dividing the power by 2, and multiply x to result when the power is odd.
// Square x each time along with halving of the power until it reaches 0.

class Solution2 {
    public double myPow(double x, int n) {
        double result=1.0;

        if(n<0){
            x=1/x;
            n*=-1;
        }

        while(n!=0){

            if(n%2!=0){
                result*=x;
            }

            x=x*x;
            n=n/2;
        }

        return result;
    }
}
