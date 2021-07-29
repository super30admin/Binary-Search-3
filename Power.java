class Power {
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1.0;
        }
        long N = n;

        if (N < 0) {
            x=1/x;
            N=-N;
        }
        double pow = 1;
        double cur = x;
        for (long i=N; i>0; i/=2) {
            if ((i%2) == 1) {
                pow = pow * cur;
            }
            cur = cur * cur;
        }
        return pow;
    }
}