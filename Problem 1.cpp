//Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    //O(logn) 
    double myPow(double x, int n) {
        if(n==0)
            return 1;
        
        
        double val = myPow(x, n/2);
        
        if(n%2!=0){
            if(n>0){
                return val*val*x;
            }
            else{
                return val*val*(1/x);
            }
        }
        
        else{
            return val*val;
        }
    }
};