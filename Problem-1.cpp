// https://leetcode.com/problems/powx-n/
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// if the n is negative, mark it and make n positive.
// If n is even, reduce it by half and multiply x with itself.
// If n is odd, multiply x with the answer and then do step 2.

class Solution {
    public:
        double myPow(double x, int n) {
            long long N = n;
            if(N < 0) {
                x = 1/x;
                N *= -1;
            }
            double ans = 1.0;
            while(N>0){
                if(N%2 == 1){
                    ans *= x;
                }
                x *= x;
                N = N/2;
            }
            return ans;
            
        }
    };