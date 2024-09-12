//Time Complexity : O(log n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
// Keep dividing the N value by 2 until reaches 1.
// We have observed that when the value of n is negative the number is being multiplied to itself.
// By using recursion we can form our base case and our logic
public class Power {
    public double myPow(double x, int n) {
        return helper(x, n);

    }

    public double helper(double x, int n) {
        if (n == 0)
            return 1;

        double res = helper(x, n / 2);

        if (n % 2 == 0)
            res = res * res;
        else {
            if (n < 0) {
                return res * res * 1 / x;
            }
            return res * res * x;
        }
        return res;
    }

    public static void main(String args[]) {
        Power obj = new Power();
        double ans = obj.myPow(2, 10);
        System.out.println(ans);
    }
}
