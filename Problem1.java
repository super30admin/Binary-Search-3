//Time Complexity : O(logn)
//Space Complexity: O(1)
class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0){
            return 1.00;
        }
        double val = myPow(x,n/2);
        if(n % 2 == 0){
            return val * val;
        }
        else{
            if(n > 0){
                return val * val * x;
            }
            else{
                return val * val * (1/x);
            }
        }
    }
}