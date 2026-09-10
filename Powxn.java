//Time Complexity: O(logn)
//Space Complexity: O(logn)
class Solution {
    public double myPow(double x, int n) {

        //base case
        if(n == 0) return 1;

        double result = myPow(x, n/2);

        if(n%2 == 0){
            return result*result;
        }
        else
        {
            if(n < 0){
                return result * result * (1/x);
            }
            return result*result*x;
        }
    }
}