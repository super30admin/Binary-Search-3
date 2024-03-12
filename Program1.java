//acepted on LT
//tIME O(log n) idea just divide and recurse
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        
    int m = n % 2;
    double h = myPow(x,n/2);
    if(m==0){
        return h*h;
    }
    else{
        if (n > 0) {
                return x * h * h;
            } 
        else {
                return (h * h) / x;
            }
    }
    }
}