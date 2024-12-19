
// recursion
// Time complexity = O(log(n))
// Space complexity= O(log(n))
class Solution {
    public double myPow(double x, int n) {
        if(n<0) {
            x= 1/x;
        }
        return helper(x,n);

    }
    private double helper(double x, int n) {
        if(n==0) return 1.0;
        double re = helper(x,n/2);
        if(n%2==0) {
            return re*re;
        } else {
            return re*re*x;
        }
    }
}