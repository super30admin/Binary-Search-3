// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
/*
 * if the power is positive we take x, otherwise 1/x
 * then recursively caluclate the value
 */

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if( N < 0) {
            x = 1/x; //-ve power implies sqrt
            N = -N; //making it positive
        }
        
        return fastPow(x, N);
    }
    
    private double fastPow(double x, long n) {
        if(n == 0) { // for 0 mreturn 1
            return 1.0;
        }
        double half = fastPow(x, n/2); // keep making it half and compute the value
        if(n%2 == 0) {
            return half * half; 
        } else {
            return half * half * x; // 5= 2*2*1
        }
    }
}