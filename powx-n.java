class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0) return 1; // if n which is the power is 0, we return 1.

        //logic
        double result = myPow(x, n/2); //we compute the result with getting the power method
        if(n % 2 == 0) { // if n is even
            return result * result; // we return result square
        }
        else { // if n is odd
            if(n > 0) { // if is positive
                return result * result * x; // we return result square * x
            }
            else { // if n is negative
                return result * result * 1/x; // we return result square * 1/x
            }
        }
    }
}
// tc and sc - O(log n) and O(1)