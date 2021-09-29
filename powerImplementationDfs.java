// Time Complexity: O(log(n)*log(n)) where n is power
// Space Complexity: O(1)
// Idea here is to divide the power by 2 each time and when we reach to power 0 we have calculated value of recursion 
// so we keep multiplying the calculated value to previous calculated value
// thereby getting the final value
class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        double result = myPow(x, n/2);
        if(n%2==0) {
            return result*result;
        } else {
            if(n>0) {
                return result*result*x;
            } else {
                return result*result* (1/x);
            }
        }
    }
}