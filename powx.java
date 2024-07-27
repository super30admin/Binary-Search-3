//time O(log n)
//space O(1)

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0) return 1.0;
            
        //logic
        double result = myPow(x, Math.abs(n/2));
        if(n % 2 == 0) {
            result = result * result;
        } else {
            result = result * result * x;
        }
        
        if (n < 0) return 1/result;
        return result;
    }
}
