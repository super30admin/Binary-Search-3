class Solution {
    public double myPow(double x, int n) {
        if(n<0) x=1/x;
        double result=1.0;
        while(n!=0){
            if(n%4==1){
                result=result*x;
            }
            if(n%4==2){
                result=result*x*x;
            }
            if(n%4==3){
                result=result*x*x*x;
            }
            n=n/4;
            x=x*x*x*x;
        }
        return result;
    }
}
