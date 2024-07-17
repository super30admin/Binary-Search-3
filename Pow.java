// Time Complexity : O(log n)
// Space Complexity : o(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Base Case: If the exponent n is 0, return 1.0 since any number to the power of 0 is 1.
//Recursive Call: Recursively calculate myPow(x, n/2) to get the result for half the exponent.
//Combine Results: Square the result for even n. For odd n, multiply by x if n is positive, or by 1/x if n is negative.

class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        double result = myPow(x, n/2); // recursive call to the function
        // if n is even
        if(n%2 == 0){
            result = result * result;
        }
        // if n is odd
        else{
            if( n > 0){
                result = result * result * x;
            }
            else{
                result = result * result * 1/x;
            }
        }

        return result;
    }
}