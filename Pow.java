package binarysearch2;

//understad why interger overflow error if kept N type int

class Pow {
    public double myPow(double x, int n) {
        long N = n;
        double ans = 1;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double temp = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans = ans * temp;
            }
            temp = temp * temp;
        }
        
        return ans;
    }
}