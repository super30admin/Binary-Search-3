class PowerX {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double y = myPow(x, n / 2);

        if (n % 2 == 0) {
            return y * y;
        } else if (n % 2 != 0) {
            if (n >= 0) {
                return y * y * x;
            } else {
                return y * y * 1 / x;
            }
        }
        return y;
    }
}
