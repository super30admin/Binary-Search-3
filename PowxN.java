// Time Complexity : O(logn)
// Space Complexity : O(h) , h = height of resursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Recursing for n/2 and multiplying the results.

// Notes : For x raised to n, recursively find x raised to n/2, while checking if n is even or odd and positive or negative.

public class PowxN {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        
        double res = myPow(x, n/2);
                
        if(n % 2 == 0){
            return res * res;
        } else {
            if( n < 0){
                return res * res * 1/x;
            } else {
                return res * res * x;
            }
            
        }  
    }
}
