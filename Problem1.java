class Problem1 {
    public double myPow(double x, int n) {
        if(n>0){
            return recurpow(x,n);
        }else{
            return (1/recurpow(x,-1* n))   ;
        }

    }
    //TC:O(logn)
    //SC :O(1)
    static double pow (double x, int n) {
        double result = 1;
        while(n>0) {

            n=n/2;
            x=x*x;
            if(n%2!=0) {
                result = result* x;
            }
        }
        return result;


    }
    //TC:O(logn)
//SC:O(logn)
    static double recurpow(double x,int n){

        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        double result = 0;
        result = recurpow(x*x,n/2);

        if(n%2!=0){
            result=result*x; //even


        }

        return result;
    }
}


