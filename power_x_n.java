/*
Problem: https://leetcode.com/problems/powx-n/
TC: O(log n)
SC: O(log n)
*/
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }   
        
        double result = myPow(x, n/2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            return result * result * (n < 0 ? 1/x : x);
        }
    }
}