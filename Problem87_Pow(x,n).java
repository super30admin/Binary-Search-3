//  Time Complexity : O(log(n))
// Space Complexity : O(log(n))
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    public double myPow(double x, int n) {
        // base
        if(n == 0)
            return 1.00;
        
        // logic
        double result = myPow(x, n / 2);
        if(n % 2 == 0) {
            return result * result;
        } else {
            if(n > 0) 
                return result * result * x;
            else
                return result * result * (1 / x);
        }
    }
}