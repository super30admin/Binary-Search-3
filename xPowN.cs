// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public double MyPow(double x, int n) {
    if(n == 0)
        return 1.0;
    
    //we call the function recusrively breakign into smaller sets, so that we can reuse them
    double result = MyPow(x, n/2);
    //if n is even, then multiply result with result
    if(n % 2 == 0)
        return result * result;
    else
    {
        //if n is odd and positive, then multiply result result and x
        //if n is negative, multiply with 1/x
        if(n > 0)
            return result * result * x;
        return result * result * 1/x;
    }
}