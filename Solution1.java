// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach
// 
// Time Complexity : O(logn)(dividing the problem into haf at every step)
// Space Complexity :O(logn) number of recursive calls in the stack
class Solution {
    public double myPow(double x, int n) {
        
        //base
        if(n==0) return 1;
        
        //logic
        double ans= myPow(x,n/2);
        if(n%2==0){
            return ans*ans;
        }
        else{
            if(n>0) return ans*ans*x;
            
            return ans*ans*1/x;
        }
    }
}