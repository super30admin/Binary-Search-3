//approch 1
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(logn)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {
    // approch 1 iterative
    public static double myPow(double x, int n) {
        // to store result
        double ans = 1.000;
        long num = n;
        // check if num is negative than multiply it with -1
        // at the and we inverse it.
        if (n < 0) {
            num = num * -1;
        }
        // divide num by 2 until we it becomes 0
        while (num > 0) {
            // if power is even than make x^2 and divide power by 2
            if (num % 2 == 0) {
                x = x * x;
                num = num / 2;
            } else {
                // else multiply ans with x;
                ans = ans * x;
                num = num - 1;
            }
        }
        // if num < 0 than 1 divide by and
        if (n < 0) {
            return (double) 1.0 / (double) ans;
        }
        return ans;
    }

    // approch 2 recursive
    public static double myPowRec(double x, int n) {
        // base case
        if (n == 0) {
            return 1;
        }
        double result = myPowRec(x, n / 2);
        // System.out.println("result" + result);
        // main logic
        if (n % 2 == 0) {
            return result * result;
        } else {
            if (n < 0) {
                return result * result * 1 / x;
            } else {
                return result * result * x;
            }
        }
    }

    public static void main(String[] args) {
        double x = 2;
        int n = 12;
        System.out.println(myPow(x, n));
        System.out.println(myPowRec(x, n));

    }
}