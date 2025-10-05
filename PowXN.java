public class PowXN {

    //TC: O(log n) since at every step we reduce n by half, SC: O(log n) due to recursive stack size
    public double myPow(double x, int n) {
        return power(x, n);
    }

    private double power(double x, int n) {
        if (n == 0) return 1.0;

        double power = power(x, n/2);
        if (n % 2 == 0) return power * power;
        else {
            if (n < 0) return power * power * 1/x;
            else return power * power * x;
        }
    }

    //TC: O(log n) since at every step we reduce n by half, SC: O(1)
    public double myPowIteratively(double x, int n) {
        double result = 1.0;

        if (n < 0) x = 1/x;

        while (n != 0) {
            if (n % 2 != 0) result *= x;
            x *= x;
            n /= 2;
        }

        return result;
    }
}
