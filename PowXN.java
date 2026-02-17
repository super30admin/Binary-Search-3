/*
Time Complexity : O(log n)
Space Complexity : O(log n) in the recursion stack.
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
Approach :

Instead of multiple x, n times. We can handle this with recursion where n becomes n/2 for the next recursion call. As n becomes
0, our base case returns 1 and the top most recursion call uses it to calculate the power.
We will have to keep in mind, for odd values of n to multiply with extra x.
Also, need to consider, if n is negative, then we need to do 1/x.
*/
public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        double result = myPow(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            if (n < 0) {
                return result * result * (1 / x);
            }

            return result * result * x;
        }

    }
}
