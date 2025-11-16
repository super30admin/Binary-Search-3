// Time Complexity : O(log n) as we reduce n by half at each step.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We maintain a result value intitialized with 1. At each level, we multiple x by x and then reduce n to half, if n is odd
// at any point we multiply the result with x and continue.

class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        if(n < 0){ //n as negative number case
            x = 1/x;
            n = -n;
        }

        while(n != 0){
            if(n%2 != 0){ // for odd case
                result *= x;
            }
            x *= x; //multiply x by x
            n = n/2; //reduce n by half
        }
        return result;
    }
}