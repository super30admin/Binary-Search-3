// Time Complexity :O(log n) (recursive)
//                  O(log n) (iterative)
// Space Complexity :O(log n) (recursive)
//                  :O(1) (iterative)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class PowXN {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        double result = myPow(x,n/2);
        if(n%2==0){
            return result*result;
        }else{
            if(n<0){
                return result*result*1/x;
            }else{
                return result*result*x;
            }
        }
    }

    public double myPowIterative(double x, int n){
        double res = 1.0;

        if(n<0){
            x=1/x;
            n= Math.abs(n);
        }

        while(n!=0){
            if(n%2!=0){
                res = res*x;
            }
            x=x*x;
            n=n/2;
        }
        return res;
    }
}
