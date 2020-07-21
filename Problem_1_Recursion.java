// Time complexity - O(logn)
// Space complexity - O(logn)

// Recursive solution

class Solution {
    public double myPow(double x, int n) {
        // base
        if(n == 0) return 1;
        // logic
        double result = myPow(x,n/2);
        if(n%2 == 0){
            return result*result;
        }else{
            if(n < 0){
                return result*result*(1/x);
            }else{
                return result*result*x;
            }
        }
    }
}
