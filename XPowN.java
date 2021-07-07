/*
Time: O(log N)
Space: O(log N) stack space for recursion
Algorithm:
=========
1. Basic idea is tthat (x^n is always equal to x^(n/2)*x^(n/2)) 
2. Instead of recursively calculating x^n => calculate half and then half*half is equal to x^n
3. If exponent is negative, negate it and change x to 1/x to call helper method
4. Handle odd and even n cases as well
*/

class Solution {
    public double myPow(double x, int n) {
        long num = n;
        if(num < 0) {
            return power(1/x, -1*num); // num < 0, so to calculate change x and n
        }
        return power(x, num);
    }
    
    private double power(double x, long n) {
        if(n == 0) return 1; 
        if(n == 1) return x;
        
        double half = power(x, n/2); //calculate half
        
        if(n%2 == 0) 
            return half*half; //even n
        else
            return x*half*half; // odd n
    }
}