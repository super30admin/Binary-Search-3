// Time Complexity : O(logN)  
// Space Complexity : O(logN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double myPow(double x, int n) {
        //base case
        if(n==0){ 
            return 1.0;
        }
        double temp = myPow(x, n/2);
        if(n%2==0){ //even when n both positive and negative
            return temp*temp;
        }
        else{ //odd 
            if(n<0){
                return temp*temp*(1/x);
            }
            return temp*temp*x;
        }
    }
}
