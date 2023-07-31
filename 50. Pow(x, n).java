// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes     
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// when n is even we return temp * temp, temp is the x to the power n/2. 
// if n is odd and -ve we return temp * temp * 1/x, if n is odd and +ve we return temp * temp * x; 
class Solution {
    public double myPow(double x, int n) {
        //base
        if(n==0) return 1.0;

        //logic
        double temp = myPow(x,n/2);
        if(n%2==0)
        {
            return temp*temp;
        }
        else {
            if(n<0)
            {
                return temp*temp *(1/x);
            }
            else {
                return temp* temp * x;
            }
        }

    }
}