// Pow(x,n) (https://leetcode.com/problems/powx-n/)

// Time Com: O(1)
// Space Com: O(log n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

public class pow {
    public static double myPow(double x, int n) {
        // base case
        if (n == 0) {
            return 1.000;
        }

        // Logic
        double res = myPow(x, n / 2);
        if (n % 2 == 0) {
            return res * res;
        } else {
            if (n < 0) {
                return res * res * (1 / x);
            } else {
                return res * res * x;
            }
        }
    }

    public static void main(String[] args) {
        double x = 2.0000;
        int n = 10;
        System.out.println(myPow(x, n)); // output: 1024.0
    }
}