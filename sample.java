//pow(x,n
//tc log n
//sc 1
class Solution {
    public double myPow(double x, int n) {
        
        if(n==0) return 1.000;
        
        double temp = myPow(x, n/2);
        
        if((n % 2) == 0){
            
            return temp * temp;
        }
        else{
            
            if(n>0){
                return temp * temp * x;
            }
            return temp * temp * (1/x);
        }
    }
}
