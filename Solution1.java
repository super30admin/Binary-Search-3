//Time complexity: O(logn)
//Space complexity: O(1)

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n < 0) {
            x = 1/x;
            return (n%2==0) ? myPow(x*x, -(n/2)) : x*myPow(x*x, -(n/2));
        }
        else {
            return (n%2==0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
        }
    }
}