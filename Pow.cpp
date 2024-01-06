class Solution {
public:
    double myPow(double x, int n) {

       //base

       if(n == 0) return 0;

       double result = myPow(x,n/2);

       if(n < 0)
       {
           n = n*-1;
           x=1/x;
       } 
       
       if(n%2 == 0)
       {
           result = result * result;

       }else
       {
           result = result * result *x;
       }

       return result;
    }
};