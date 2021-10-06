// Time Complexity - O(logn) where n is the input
// Space Complexity - O(1)

class Solution {
    
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return myLongPow(x, N);
    }
    
    public double myLongPow(double x, long n) {
        if(n == 0) return 1.0;
        
        double result = myLongPow(x,n/2);
        if(n%2 != 0){
            return  result * result * x;    
        }
        else return result * result;
    }
}