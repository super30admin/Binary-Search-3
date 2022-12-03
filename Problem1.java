class Problem1 {
    public static double myPow(double x, int n) {
        long pow = n;
        double res = 1;
        if (n < 0) {
            pow = -pow;
            x = 1 / x;
        }

        while (pow > 0) {
            if (pow % 2 != 0) {
                res *= x;
            }
            x *= x;
            pow /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        double x = 1.001;
        int n = 4;
        System.out.println(myPow(x, n));
    }
}