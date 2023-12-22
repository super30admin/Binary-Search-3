// Time Complexity : O(log n) 
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

public class Powxn {


    public double myPow(double x, int n) {
        // Base case
        if (n == 0) {
            return 1;
        }

        // Recursive calculation
        double result = myPow(x, n / 2);

        // Handle negative exponent
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        // Update result based on parity of n
        if (n % 2 == 0) {
            result *= result;
        } else {
            result *= result * x;
        }

        return result;
    }

        public static void main(String[] args) {
        Powxn solution = new Powxn();

        
        double x = 2.0;
        int n = 5;

        double result = solution.myPow(x, n);

        System.out.println("Result: " + result);
    }
}
