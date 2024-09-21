//time complexity: O(log n)
//space complexity is O(log n)
class pow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double result = myPow(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            if (n > 0) {
                return result * result * x;
            } else {
                return result * result * 1 / x;
            }
        }
    }

    public static void main(String[] args) {
        pow sol = new pow();

        // Test cases
        double x1 = 2.0;
        int n1 = 10;
        System.out.println(x1 + " raised to the power of " + n1 + " is: " + sol.myPow(x1, n1)); // Expected: 1024.0

        double x2 = 2.1;
        int n2 = 3;
        System.out.println(x2 + " raised to the power of " + n2 + " is: " + sol.myPow(x2, n2)); // Expected: ~9.261

        double x3 = 2.0;
        int n3 = -2;
        System.out.println(x3 + " raised to the power of " + n3 + " is: " + sol.myPow(x3, n3)); // Expected: 0.25
    }
}
