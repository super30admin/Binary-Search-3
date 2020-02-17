//Time complexity : O(log(n))

class Solution {
    
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(x == 0)
            return 0;
        if(n == Integer.MIN_VALUE)
            n += 2;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        double half = myPow(x,n/2);
        if(n%2==0)
            half = half * half;
        else
            half = x * half * half;
        return half;
    }
}