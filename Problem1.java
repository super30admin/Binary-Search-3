// Time Complexity: O(log(N))
// Space Complexity: O(log(N))
// Passed Leetcode
class Solution {
    
    public double binarySearch(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        
        double val = binarySearch(x, n / 2);
        double result = val * val;
        if (n % 2 != 0) {
            result = result * x;
        } 
        
        return result;
    }
    public double myPow(double x, int n) {
        
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        return binarySearch(x, Integer.valueOf(n));
    }
}