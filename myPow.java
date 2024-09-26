// Time Complexity : O(log n) n is power
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        
        if(n==1) return x;
        
        if(n<0){
            if(n==Integer.MIN_VALUE){
             n+=2
         }
            x = 1/x;
            n=-n;
        }
        double ans =  myPow(x,n/2);
        
        if(n%2==0)
        {
            
            return ans*ans;
        }
        else{
            return ans*ans*x;
        }        
    }
}