// TC : O(logn)
// SC : O(logn)

class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        double result = myPow(x,n/2);
        
        if(n%2==0){
            result = result*result;
        }
        else{
            if(n<0){
            result = result*result*1/x;
            }
            else{
                result = result*result*x;
            }
        }
        return result;
       
    }
}