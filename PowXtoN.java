// Time complexity: O(logn)
// Space Complexity: O(1)

class Solution{
    public double myPow(double x, int n) {

        // base case
        if(n == 0) return 1;

        double temp = myPow(x, n/2);

        if(n % 2 == 0){
            return temp * temp;
        }
        else {
            // n is odd
            if(n < 0) return temp * temp * 1/x;
            else {
                return temp * temp * x;
            }
        }


    }
}
