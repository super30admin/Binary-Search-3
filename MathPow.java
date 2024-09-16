//TC: O(logn)
//SC: O(1)

public class MathPow {
    public double myPow(double x, int n) {
        if(x == 1 || n == 1)
            return x;
        boolean flag = false;
        int a = 1;
        // Handling the negative power
        if(n < 0){
            flag = true;
            // if negative power is equal to int min value
            if(n == Integer.MIN_VALUE){
                n = Integer.MAX_VALUE;
                a = -1;
            }
            else{
                n *= -1;
            }
        }
        double res = 0;
        res = helper(x, n);
        if(a < 1)
            res *= x;
        if(flag)
            return 1/res;
        return res;
    }
    // Recursively generating the power start from 0 till the n and incrementing each iteaton byy n/2
    private double helper(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        double z = helper(x, n/2);
        if(n%2 == 0){
            return z*z;
        }
        return z*z*helper(x, n%2);
    }
}