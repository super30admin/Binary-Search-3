// square the base and half the exponent. If n is negative, invert x and use 1/x as the new base. Multiply the result by x only when n is odd, ensuring efficient computation.
//Time Complexity: O(log n)
//Space Complexity: O(1)

class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        if(n < 0) {
            x = 1/x;
        }
        while(n != 0) {
            if(n%2 != 0) {
                result = result * x;
            }
            x = x * x;
            n = n/2;
        }
        return result;
    }
}