public class Problem1 {

    //TC : O(logn)
    //SC : O(logn)
    public double myPow(double x, int n) {
        //base case
        if (n == 0) {
            return 1;
        }
        //logic
        double result = myPow(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            if (n > 0) {
                return result * result * x;
            }
            return result * result * 1 / x;
        }
    }
}
