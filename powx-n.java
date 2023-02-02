// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * divide the n value into half for every recursive call and check if the n value is odd or even. for odd , there an extra x value in the multiplication.
 */
class Solution {
    public double myPow(double x, int n) {
        // base
        if (n == 0)
            return 1.000;
        if (x == 0)
            return 0.000;

        // call function recursively
        double result = myPow(x, n / 2);

        // if n is even
        if (n % 2 == 0) {
            return result * result;
        } else
        // odd
        {
            // if n is negative
            if (n < 0) {
                return result * result * (1 / x);
            } else {
                return result * result * x;
            }
        }
    }
}

// iterative approach

// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Iterative method:
 * use stack to store the recursive call.
 */
class Solution {
    public double myPow(double x, int n) {
        double result = 1.000;
        Stack<Integer> st = new Stack<>();
        while (n != 0) {
            st.push(n);
            n = n / 2;
        }

        while (!st.isEmpty()) {
            int curr = st.pop();
            if ((curr % 2) == 0) {
                result = result * result;
            } else {
                if (curr > 0) {
                    result = result * result * x;
                } else {
                    result = result * result * (1 / x);
                }
            }
        }

        return result;
    }
}