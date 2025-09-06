// This solution uses iterative solution to reduce n by half everytime. If n is even, we multiply x by itself and if its odd at any point we multiply result with x itself
class Solution {
    public double myPow(double x, int n) {
        
        double result = 1.0;

        if(n<0) {
            x = 1/x;
            n = n*-1;
        }

        while(n!=0) {

            if(n%2!=0) {
                result = result * x;
            }

            n=n/2;
            x = x * x;
        }
        return result;
    }
}
