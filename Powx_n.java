//tc : O(logn)
//sc : O(h); recursion stack; h = height of tree
public class Powx_n {
    public double myPow(double x, int n) {

        if (n == 0) return 1;

        double temp = myPow(x, n / 2);

        if (n % 2 != 0) {
            if (n < 0)
                return temp * temp * 1/x;
            else
                return temp * temp * x;
        }
        else {
            return temp * temp;
        }


    }
}
