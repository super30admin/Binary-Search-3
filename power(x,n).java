//Problem1 
// Pow(x,n) (https://leetcode.com/problems/powx-n/)

class Solution {
    public double myPow(double x, int n) {
        
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        
        return doublePow(x, n);
    }
    
    private double doublePow(double x, int n){
        if(n == 0)
            return 1.0;
        
        double half = doublePow(x, n / 2);
        
        if(n % 2 == 0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}