// Time Complexity :O(log n) n is  the given input power
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public double myPow(double x, int n) {

        //base case
        if(n == 0)
            return 1.00;

        //logic
        double result = myPow(x,n/2);

        //evn
        if(n % 2 == 0){
            return result * result;
        }

        //odd
        else{
            //power is positive
            if(n > 0)
                return result * result * x;
            else
                return result * result * 1/x;
        }
    }
}
