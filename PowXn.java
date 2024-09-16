// Time Complexity : O( log n) 
// Space Complexity : O(log n) elements in recursive stack. or Depth of recursive tree. 

// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// We use recursion and the value returned from recursion(val) is used to apply/check  val module of 2 equal to 0, if true then return val.
// else we check if n > 0 then return val * val * x; otherwise app return val * val * 1/x

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
//Memory Usage: 36.9 MB, less than 40.68% of Java online submissions for Pow(x, n).
class Solution {
    public double myPow(double x, int n) {
        //base case
        if (n==0){
            return 1;
        }
        double val= myPow(x,n/2);
        if (n % 2==0){
           return  val* val;
        }else {
           if (n>0){
             return val* val* x;   
           }else {
             return val * val * (1/x);   
           }
        }
    }
}