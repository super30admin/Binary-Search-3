class Solution {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE) {
            if(x > 1.0f) {
                return 0f;
            } else {
                return 1f;
            }
        }
        
        double X = x;
        int N = n;
        
        // if 'n' is a negative number we should devide instead of multiply
        if(N < 0) {
            N = -N;
            X = 1 / x;
        }
        
        return halfPow(X, N);
    }
    
    // recursive part
    private double halfPow(double x, int n) {
        // base case, if n is zero 
        if(n == 0) {
            return 1.0f;
        }
        // if n is 1 just return the value
        if(n == 1) {
            return x;
        }
        int half = n / 2;
        double halfPow = halfPow(x, half);
        
        if(n % 2 == 0) {
            return halfPow * halfPow;
        } else {
            return halfPow * halfPow * x;
        }
    }
}
