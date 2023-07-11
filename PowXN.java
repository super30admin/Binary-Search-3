import java.text.DecimalFormat;

public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;

        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n < 0)
                return temp * temp * (1 / x);
            else
                return temp * temp * x;
        }
    }

    public static void main(String[] args) {
        PowXN solution = new PowXN();

        // Test Case 1
        double x1 = 2.0;
        int n1 = 3;
        double result1 = solution.myPow(x1, n1);
        System.out.println("Result: " + result1);

        // Test Case 2
        double x2 = 2.5;
        int n2 = -3;
        double result2 = solution.myPow(x2, n2);
        System.out.println("Result: " + result2);

        DecimalFormat df = new DecimalFormat("#.00");
        // Test Case 1
        double x3 = 2.0;
        int n3 = 10;
        double result3 = solution.myPow(x3, n3);
        System.out.println("Result: " + df.format(result3));

    }
}