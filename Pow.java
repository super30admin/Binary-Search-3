public class Pow {
    //iterative
    public double myPow(double x, int n){
        if(n == 0) return 1;
        if(n < 0){
            // n = -1 * n;
            x = 1.0 / x;
        }
        double result = 1;
        while(n != 0){
            if( n % 2 != 0){
                //odd term 
                result = result * x;
            }

            x = x * x;
            n = n/2; //half the n at every point
        }
        return result;

    }


    //o(log n) recursive
    // public double myPow(double x, int n) {
    //     if(n == 0) return 1;
    //     double result = myPow(x, n/2);
        
    //     if(n % 2 == 0){
    //         //even 
    //         return result * result;
    //     }else{
    //         if(n < 0) return result * result * (1/x);
    //         return result * result * x; 
    //     }
    // }
}
