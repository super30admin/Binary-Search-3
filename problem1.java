// Problem1 Pow(x,n) (https://leetcode.com/problems/powx-n/)

// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
//approach: we follow recursive approach where the current value is equal to value of 2 calls of pow(x,n/2); slifght variations added for odd value of n


class Solution {
    public double myPow(double x, int n) {

        if(n==0)
        {
            return 1.0;
        }
        double result = myPow(x,n/2);

        if(n%2==0)
        {
            return result*result;
        }
        else
        {
            if(n>0)
            {
                return result*result*x;
            }
            else
            {
                return result*result/x;
            }
        }
        
    }
}