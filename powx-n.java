// Time Complexity: O(log n) as in this algorithm we divide value of n by half at each pass.
//Space Complexity: O()

class Solution {
    double result;
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        
        double result = myPow(x,n/2);
        if(n%2 == 0){
            return result * result;
        } else {
            if(n<0){
                return result * result * (1/x);
            } else {
                return result * result * x;
            }
        }
        
    }
}