// In this problem, we are trying to use recursion to reach the base case that anything raise to 0 is 1, so we recursively divide 
// our calls by 2 until we reach x^0

// Time Complexity : O(log n)
// Space Complexity : O(log(n))  recursive stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Powxn {
    public double myPow(double x, int n) {
        // Base case
        if (n == 0) {
            return 1.0;
        }
        // Recursive call
        double y = myPow(x, n / 2);
        // If even
        if (n % 2 == 0) {
            return y * y;
        } else {
            // If odd and positive
            if (n > 0) {
                return y * y * x;
            } else {
                // If odd and negative
                return y * y * 1 / x;
            }
        }
    }

    public static void main(String[] args) {
        Powxn p = new Powxn();
        System.out.println(p.myPow(2.0, 4));
    }
}
