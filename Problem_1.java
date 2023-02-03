// 50. Pow(x, n)
// Time Complexity : O(log n)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// Recursive

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0)
            return 1.00;

        //logic
        double result = myPow(x, n/2);
        if(n%2 == 0) { //even
            return result * result;
        }
        else { //odd
            if(n > 0)
                return result*result*x;
            else
                return result*result*(1/x);
        }
    }
}



// Iterative
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// we'll be convering x to its inverse and make N positive, if the given N is negative.
// Otherwise, iteratibvely compute the cur product and update the resultant pow variable when ever encounter an odd power.


 class Solution {
     public double myPow(double x, int n) {
         if(n == 0)
         return 1.0;
         long N = n;
         if(N < 0) {
             x = 1/x;
              N = -N;
        }
        double pow = 1;
        double cur = x;
        for(long i = N; i > 0; i/=2) {
            if((i%2) == 1) {
                pow=pow*cur;
            }
            cur=cur*cur;
        }
        return pow;
     }
 }