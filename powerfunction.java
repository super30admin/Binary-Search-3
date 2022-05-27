// Best iterative solution TC O(logn ) and SC O(1) no stack space

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        
        while(N > 0){
            if(N %2 == 1) result = result * x;
            x = x*x;
            N = N/2;
            
        }
        return result; 
      }
}

/* 
// Recursive solution:TC O(logn) 
// SC (1) and O(logn) stack space 
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n < 0) {
            if(n==Integer.MIN_VALUE){

             n+=2;
            System.out.println(n);

         }
            n = -n;
            x = 1/x;
        }
        
        
        
        if(n%2 == 0){
            double temp = myPow(x, n/2);
            return temp * temp;
            
        }else
        {
            double temp = myPow(x, n/2);
            return temp * temp *x;
            
        }
        
    }
}

*/
