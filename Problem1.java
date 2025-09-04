// ## Problem1 
// Pow(x,n) (https://leetcode.com/problems/powx-n/)
// Time Complexity : log(n)
// Space Complexity: O(1) , all are constants which are used


class Solution {
    public double myPow(double x, int n) {

        // to save n / 2 values
        long exp = n;
        // if -ve power then x is 1/x and to iterate over exp make it from -ve to +ve
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }
        double base = x;
        double result = 1;
        while(exp > 0) {
            // If off then multiple result with base value
            if( (exp % 2) == 1) {
                result = result * base;
            }
            // else base is multiplied by itseld and exp is divided by 2 
            base = base * base;
            exp = exp / 2;
        }
        return result;
    }
}