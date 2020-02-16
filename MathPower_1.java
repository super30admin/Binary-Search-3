class Solution {
    public double myPow(double x, int n) {
        
        //Base Case
        if(n == 0){
            return 1;
        }
        
        //Logic
        if(n < 0){
            x = 1/x;
            n = -(n);
        }
        
        double result = myPow(x, n/2);
        if(n % 2 == 1){
            result = result * result * x;
        }else{
            result = result * result;
        }
        
        return result;
        
    }
}