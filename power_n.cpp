// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// We use binary search to reduce the search by half. If n is even, make n->n/2 and calculate square of power of x, n/2 
// Id n is odd and >0, make n->n/2 and calculate square of power of x, n/2 * x; when n <0, make n->n/2 and calculate 
//square of power of x, n/2 * 1/x. When n = 0, return 1.
// ex: 2^5 => 2^2 * 2^2 * 2
//     2^2 => 2^1 * 2^1
//     2^1 => 2^0 * 2^0 * 2
//     2^0 => 1

class Solution {
public:
    double myPow(double x, int n) {
        //base 
        if( n == 0)
        {
            return 1;
        }
        double re = myPow(x,n/2);
        if(n%2 == 0)
        {
            return re * re;
        }
        else
        {
            if(n<0)
            {
                return re * re * (1/x);
            }
            else
            {
                return re * re * x;
            }
        }
    }
};