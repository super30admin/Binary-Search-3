
// TC : 0(log n)
// SC : 0(1)

package S30_Codes.Binary_Search_3;

public class Pow_x_n {
    public double myPow(double x, int n) {
        long pow = n;
        if(n < 0){
            x = 1/x;
            pow = -pow;
        }

        double res = 1;

        while(pow > 0){
            if(pow%2 == 1){
                res *= x;
            }
            pow /= 2;
            x *= x;
        }

        return res;
    }
}