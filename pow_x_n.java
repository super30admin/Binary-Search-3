// Time Complexity = O(logn)
// space complexity = O(logn)
// class Solution {
//     public double myPow(double x, int n) {
//         //base 
//         if(n==0) return 1.0;
//         //logic 
//         double res=myPow(x,n/2);
//         if(n%2==0) return res*res;
//         else{
//             if(n<0) return res*res*(1/x);
//             else return res*res*(x);
//         }
//     }
// }

// Time Complexity = O(logn)
// space complexity = O(1)
class Solution {
    public double myPow(double x, int n) {
        double result=1.0;
        if (n < 0) {
            x = 1 / x;
            n = n * -1;
        }
        while(n!=0){
            if(n%2!=0){
                result=result*x;
                // n=n-1; --> no need of this because in java 1/2 = 0
            }
            n=n/2;
            x = x * x;
        }
        return result;
    }
}