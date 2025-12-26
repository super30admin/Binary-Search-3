class Solution {
    public double myPow(double x, int n) {
        double result=1.0;
        //base
        if(n==0) return 1.0;
        //logic
        double half = myPow(x, n/2);
        if(n%2==0){//even
            result = half * half;
        }else{//odd
            if(n>0){ //positive
                result = half * half * x;
            }else{//negative
                result = half * half * (1/x);
            }
        }
        return result;
    }
}