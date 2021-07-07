    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/powx-n/
    Time Complexity for operators : o(logn) .. n is the length of the string
    Extra Space Complexity for operators : o(1) without recursive stack and o(log(n)) with recursive  stack
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : for loop and just to (x * x) till for loop reaches till n. O(n) time complexity
        # Optimized approach: 
                              
            # 1. 
                    A) Do the recursive call to the function with x and n/2. (n/2 because we are only going to
                        calculate half side of the tree. Like drawn below)
                    B) Then ,we will check if n is even or odd. If it is event then just multiply val and return.
                    C) If it is odd then check if it is positive or negative
                        if it is positive, then just multiple val * val * x
                        else val * val * 1/x

            2^10
            /  \
          2^5   2^5
          /\     / \
        2^2 2^2 2^2 2^2 
    */  

class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0)
            return 1;
        
        double val = myPow(x,n/2);
        
        if(n % 2 == 0){
            return val * val;
        }else{
            if(n>0){
               return val * val * x; 
            }else{
                return val * val * 1/x;
            }
        }
    }
}