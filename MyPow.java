// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyPow {
    public double myPow(double x, int n) {

        if (n == 0)
            return 1.0;
        double re = myPow(x, n / 2);
        if (n % 2 == 0) {
            re = re * re;
        } else {
            if (n < 0) {
                re = re * re * 1 / x;
            } else {
                re = re * re * x;
            }
        }
        return re;
    }
}