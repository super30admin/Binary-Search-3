// Time Complexity :O(log(n))
// Space Complexity : O(log(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    double result;
    public double myPow(double x, int n) {
        if(n == 0) return 1;

//Divide the power in half and get the value recursively
        double temp = myPow(x, n/2);
        //Multiply it by itself to get the result. Check for edge cases ie even and odd power and negative power
        if(n%2 == 1){
            result = temp *temp* x;
        } else if(n%2 == -1){
            result = temp *temp* (1/x);
        }
        else{
            result = temp *temp;
        }
        return result;
    }

    
}