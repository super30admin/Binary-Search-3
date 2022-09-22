//Time: Logarithmic
//Space: n/2
class Solution {
    public double myPow(double x, int n) {
       //base
        
        if(n == 0) return 1.00;
        
        double temp = myPow(x, n/2);
       
        if(n % 2 == 0) {  
           return temp*temp;
       } else {
           if(n < 0) {
               return temp * temp * (1/x); 
           } else {
               return temp * temp * x;
           }
       }
    }
}