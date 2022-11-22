class Solution {
    public double myPow(double x, int n) {
        long pow = n;
        if(n<0){
            pow = -pow;
            x =1/x;
        }

        double res =1;
        while(pow>0){
            if(pow%2!=0){
                res = res*x;
            }

            x *=x;
            pow /= 2;
        }
        return res;
    }
}

