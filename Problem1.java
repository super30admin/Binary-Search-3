// Time Complexity : O(log(n))
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public double myPow(double x, int n) {
        //base 
        if(n == 0){
            return 1;
        }
        //logic
        //set a temp that will be called recursively with the power divded by two each time
        double t = myPow(x,n/2);
        //now check if it is even or odd
        //even
        if(n%2 == 0){
            //don't multiply extra 
            return t * t;
        }
        //odd now check if negative or positio to do x or 1/x
        else{
            //positive
            if(n > 0){
                return t * t * x;
            }
            //negative
            else{
                return t * t * (1/x);
            }
        }
    }
}