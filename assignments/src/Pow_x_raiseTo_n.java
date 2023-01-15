// Time: O(logn)
// Space: O(1)

public class Pow_x_raiseTo_n {

    public double myPow(double x, int n) {

        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        double product = 1;
        double ans = x;
        for (long i = N; i>0; i/=2){
            if ((i%2) == 1){
                product = product * ans;
            }
            ans = ans * ans;
        }
        return product;
    }
}