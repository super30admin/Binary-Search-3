public class Pow {

    // TC: O(log n) We are halving the value of n every time
    // SC: O(log n)
    public double myPow(double x, int n) {
        // Base condition
        if(n == 0) return 1.0;

        // x^5 = x^2 * x^2 * x
        // x^6 = x^3 * x^3
        // x^-6 = x^-3 * x^-3 * 1/x
        // Logic
        double result = myPow(x, n / 2);
        if(n % 2 == 0) return result * result;
        else
            if(n > 0) return result * result * x;
            else return result * result * 1 / x;
    }
}
