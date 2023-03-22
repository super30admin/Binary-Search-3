class Solution {
    public double myPow(double x, int n) {
     if(n==0) return 1.0;
     long N = n;
    if(N<0){
        x = (1/x);
        N = -N;
    }
    double power = 1;
    double current = x;
    for(long i = N;i>0;i/=2){
        if(i%2==1){
            power = power*current;
        }
        current = current * current;
    }
        return power;
    
    }
}