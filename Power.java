// Time complexity : O(logn)
// Space complexity : O(1)
class Power {
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        double result = myPow(x, n);
        System.out.println(result);
    }

    private static double myPow(double x, int n) {
        if (n < 0) {
            n *= -1;
            x = 1 / x;
        }
        double result = 1.0;
        while (n != 0) {
            if (n % 2 != 0) {
                result = result * x;
            }
            x = x * x;
            n = n / 2;
        }
        return result;
    }
}