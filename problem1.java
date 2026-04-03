    /**
    Time Complexity : O(log N)
    Explanation:
    We repeatedly divide n by 2 (binary exponentiation),
    so number of operations is logarithmic.

    Space Complexity : O(1)
    Explanation:
    No recursion or extra space used.

    Did this code successfully run on LeetCode : Yes (with fix)

    Any problem you faced while coding this :
    Initially failed for negative values of n, especially Integer.MIN_VALUE.
    Fixed it by converting n to long before taking absolute value,
    because abs(Integer.MIN_VALUE) overflows.
    */
    class Solution {
        public double myPow(double x, int n) {
    
            long N = n;  // convert to long to handle overflow
            double res = 1.0;
    
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
    
            while (N != 0) {
    
                if ((N % 2) == 1) {
                    res = res * x;
                }
    
                x = x * x;
                N = N / 2;
            }
    
            return res;
        }
    }