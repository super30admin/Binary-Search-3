/*
TC: O(log n)
At each recursive call we reduce n by half, so we will make only logn number of calls for the binaryExp function,
and the multiplication of two numbers is considered as a constant time operation.

SC: O(log n)
The recursive stack can use at most O(logn) space at any time.

 */
class PowRecursive {
    public double myPow(double x, int n) {

        if(n == 0) return 1;

        double result = myPow(x, n/2);

        if(n%2 == 0) {
            return result * result;
        }
        else {
            if(n < 0) {
                return result * result * 1/x;
            }
            else {
                return result * result * x;
            }
        }
    }
}
