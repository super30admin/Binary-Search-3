//TC: O(log(n))
//SC: O(log(n)) where n is power

class Solution {
public:
    double myPow(double x, int n) {
        
        long N = n;
        
        if(N<0){
            x = 1/x;
            N = -N;
        }
        
        return fastPow(x, N);
        
    }
    
    //halves the power in every recursive call until we reach n=1. then multiplies the original number with 1 and this becomes half. then this is propagated until the number^(n/2) is returned and then squared. 
    double fastPow(double x, long n){
        if(n==0) 
            return 1;
        
        double half = fastPow(x, n/2);
        
        if(n%2==0)
            return half*half;
        
        return half*half*x;
        
    }
};