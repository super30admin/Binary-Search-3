
// Time complexity - O(logn)
// Space complexity - O(logn)


class Solution {
    public double myPow(double x, int n) {

        // base case
        if(n == 0) return 1.00;


        double result = myPow(x,n/2); // power is reduced by half

        if(n % 2 == 0) {  // if n is even

            return result * result;

        }
        else {    // if n is odd and also considering the case if n is negative

            if(n < 0) {

                return result * result * (1/x);

            }
            else {
                return result * result * x;
            }


        }

    }
}