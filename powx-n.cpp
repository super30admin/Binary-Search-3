//Time - O(logn)
//space - O(logn)

class Solution {
public:
    double myPow(double x, int n) {
        return myPower(x, long(n));
    }
    
    double myPower(double x, long n){
        
        if(x==1 || n==0) return 1;
        
        if(n<0){
            n = -n;
            x = 1/x;
        }
        
        return n%2 == 0? myPow(x*x,n/2):x*myPow(x*x,n/2);
        
    }
};