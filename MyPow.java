// Time Complexity : The time complexity is O(logn) where n is the power
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public double myPow(double x, int n) {

        if(n == 0){
            return 1;
        }

        // divide n by 2
        double temp = myPow(x,n/2);

        // If n is even
        if(n%2 == 0){
            return temp*temp;
        }
        // If n is odd
        else{
            if(n < 0){
                return temp*temp*(1/x);
            }
            else{
                return temp*temp*x;
            }
        }

    }
}