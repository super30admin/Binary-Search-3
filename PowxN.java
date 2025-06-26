//Time Complexity : O(Logn)
//Space Compexity : O(1)
class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        if(n < 0){
            x = 1/x;
        }
        while(n!=0){
            if(n%2 !=0){
                result = result *x;
            }
            x=x*x;
            n=n/2;
        }
        return result;
    }
}
