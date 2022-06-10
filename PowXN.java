//Time: O(LogN) | Space: O(LogN) - depth of the recursive call stack

class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        double res = myPow(x,n/2);
        if(n%2 == 0) {
            return res*res;
        }
        return res*res*(n<0 ? (1/x): x) ;
    }
}