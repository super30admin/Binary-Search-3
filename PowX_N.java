public class PowX_N {
    /**
     * Recursive
     * Time Complexity : O(logn) 
     * Space Complexity : O(logn)
     */

    public double myPow(double x, int n) {
        //base
        if(n==0) return 1;
        //logic
        double temp = myPow(x,n/2);
        //even
        if(n%2==0) {
            return temp*temp;
        //odd
        }else{ 
            if(n<0){
                return temp*temp*(1/x);
            }
            else{
                return temp*temp*x;
            }
        }   
            
    }

    /**
     * Iterative
     * Time Complexity : O(logn) 
     * Space Complexity : O(1)
     */
    public double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double temp = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * temp;
            }
           temp = temp * temp;
        }
        return ans;
    }
}