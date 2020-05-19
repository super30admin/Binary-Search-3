// Time Complexity : Log(N)
// Space Complexity : O(Log N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//instead of using normal recursion, we lower down the time complexity from O(N) to O(LogN) by using divide ad conquer approach.
//we loop only until n/2 and simple multiply it twice.
//We handle cases when N is ODD and NEGATIVE
//We handle overflow of N by using long

class Solution {
    public double myPow(double x, int n) {
        
        if(x == 0.0) return 0.0;
        if(n == 0) return 1.0;
        
        //to handle overflow in Java as we might nultiply with -1.
        long N = (long) n;
        
        //if n is -ve integer
        if(N < 0){
           x = 1/x;
           N = -1 * N;
        }
        
        return power(x, N);
        
    }
    
    private double power(double x, long n){
        
        if(n == 0) return 1;
        if(n == 1) return x;
        
        double value = power(x, n/2);
        
        //if n is even
        if(n % 2 == 0){
            return value * value;
        }else{ // if  n is odd
            return x * value * value;
        }
        
    }
}


//==========================================================================================================

//iterative version

//T: O(LogN)
//S: O(1)

class Solution {
    public double myPow(double x, int n) {
        
        long N = n;

        //n is -ve
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        
        //instead of recursion just loop
        for (long i = N; i > 0; i /= 2) {
           if ((i % 2) == 1) {//take care of n (which is i here) is odd
                ans = ans * x;
            }
            x = x * x;
        }
        

        
        return ans;
        
    }
}