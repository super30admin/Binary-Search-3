class Solution {
    public double myPow(double x, int n) {
        
        double pow;

        int absN = n;

        if (n < 0) {
            absN = absN * -1;
        }

        if (x<0) {
            pow = findPow(-1*x, absN);
            if (n%2 != 0) 
                pow = (-1) * pow;
        } else {
            pow = findPow(x, absN);
        }

        if (n < 0) {
            pow = 1 / pow;
        }

        return pow;

    }

    public double findPow(double x, int n) {

        if (n==1) return x;
        if (n==0) return 1;

        if (n % 2 == 0) {
            double result = findPow(x, n/2);
            return result * result;
        } else {
            double result = findPow(x, n/2);
            return result * result * x; // for that 1 extra power
        }

    }
}
