// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double myPow(double x, int n) {
        // base
        if(n == 0) return 1.00;
        
        // logic
        double result = myPow(x, n/2);
        System.out.println(result);
            
        // if n is even
        if(n % 2 == 0){
            return result * result;
        }
        // if n is odd
        else{
            // n is odd and positive
            if(n > 0){
                return result * result * x;
            } 
            // n is odd and negative
            else{
                return result * result * 1/x;
            }
        }
    }
}