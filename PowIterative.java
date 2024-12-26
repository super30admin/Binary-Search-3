/*
Time complexity: O(logn)

At each iteration, we reduce n by half, thus it means we will make only logn number of iterations using a while loop.

Space complexity: O(1)

We don't use any additional space.
 */
class PowIterative {
    public double myPow(double x, int n) {

        double result = 1.0;
        if(n < 0) {
            x = 1/x;
        }

        /*
            n>0 won't work because
            1) n can be negative
            2) If we make it as positive by * by (-1), it will still not work as, if n is IntegerMinValue,
            it will be moved
         */
        while(n != 0)
        {
            if(n%2 != 0) {
                result = result * x;
            }

            n = n/2;
            x = x*x;
        }

        return result;
    }
}