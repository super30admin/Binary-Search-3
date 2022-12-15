// Time Complexity : O(log n) At every point, we are reducing the problem by half
// Space Complexity : O (log n) - internal stack
// Did this code successfully run on Leetcode : Yes 

// Recursive approach 
// Devide the problem to smaller recursilvely 
// 2^8 = 2^4 * 2^4 
// 2^4 = 2^2 * 2^2
// 2^2 = 2^1 * 2^1
// 2^1 = 2^0 * 2^0 * 2
// 2^0 = 1 -> base case 

class Solution {
public:
    double myPow(double x, int n) {
        // x^0 = 1
        if(n == 0)
            return 1;

        double result;

        // call the func on smaller problems
        result = myPow(x, int(n/2));

        // if n is odd, we need to multiply it with x 
        if(n%2 != 0){
            // for -ve n, multiply it with 1/x 
            if(n < 0)
                return (result*result*1/x);
            else
                return (result*result*x);
        } else {
            // if n is even 
            return result*result;
        }      
    }
};