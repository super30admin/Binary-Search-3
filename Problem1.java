// Time Complexity : O(log n)
//       n: exponent
// Space Complexity : O(log n)
//       n: exponent
//     Recursive stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Problem1 {
    public double myPow(double x, int n) {
        
        // base case
        if(n==0)
            return 1;
        
        // recursively call myPow ->n/2
        double result = myPow(x, n/2);
        
        // multiply result
        result *= result;
        // check odd 
        if (n%2 != 0){ 
            // check n negative
            if(n < 0)
               result *= (1/x);
            // check n positive
            else
               result *= x;
        }
        // return result
        return result; 
    }
}