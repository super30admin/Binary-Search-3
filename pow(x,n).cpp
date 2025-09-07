
class Solution {
public:
    double myPow(double x, int n) {
        if(n==0)
        return 1;
        double res = myPow(x,n/2);
        if(n%2==0)
         return res*res; // even n
        else
         {
           if(n>0)
            return res*res*x; // for odd n
           else
            return res*res*1/x; // for negative and odd n 
         }
    }
};