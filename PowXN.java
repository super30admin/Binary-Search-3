class Solution {
    // double result = 1d;
    // public double myPow(double x, int n) {
       
    //     double result = pow(x, n);
    //     return result;
    // }

    // public static double pow(double x, int n) {
    //     if (n == 0) {
    //         return 1.0;
    //     }

    //     if (n < 0) {
    //         return 1.0 / pow(x, -n);
    //     }

    //     return x * pow(x, n - 1);
    // }

    // Working Solution
    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        double temp = myPow(x,n/2);
        if(n%2==0){
            return temp*temp;
        }else{
            if(n<0){
                return temp*temp*(1/x);
            }else{
                return temp*temp*(x);
            }
        }    
    }
    
}

// Brute Force Solution gives Time Limit Exceeded error
// class Solution {
//     public double myPow(double x, int n) {
//         double result = 1d;
//         int index = Math.abs(n);
//         for(int i=0;i<index;i++){
//             result = result * x;
//         }
//         if(n<0) result = 1/result;
//         return result;
//     }
// }