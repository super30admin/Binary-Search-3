/*
 * TC: O(logn)
 * SC: O(1)
 * 
 * Approach: base case iss when my n is 0, i will just retirn 1. if n is negative, i will make x = 1/x.
 * loop until my n = 0, keep updating my x = x*x and reducing my n by 1/2. whenever i encounter n as odd, i will update my result
 * multiply x.
 */

class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        if(n == 0) return 1.0;

        if(n<0)
            x = 1/x;

        while(n != 0){
            //odd
            if(n%2 != 0)
                result = result * x;

           x = x*x;
           n = n/2;
        }
    return result;   
    }
}