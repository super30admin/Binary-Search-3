// Time Complexity : O(log n) where n is the power factor
// Space Complexity : O(log n) due to recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using the recursive approach to calculate the power via calculating the result at n/2 level each.
 */
class Solution {
    public double myPow(double x, int n) {
        if (n ==0)
            return 1.0;

        double re = myPow(x, n/2);
        //if power is even, return the result
        if (n %2==0) {
            return re*re;
        }
        // if power is odd, then we have to multiply the result with the number itself
        else {
            if (n < 0)
                // initial power was negative so we have to do 1/x
                return re*re*1/x;
            else
                // initial power was positive
                return re*re*x;
        }
    }
}