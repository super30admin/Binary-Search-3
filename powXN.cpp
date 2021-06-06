// Time Complexity :O(log n) 
// Space Complexity : O(log n )  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    double myPow(double x, int n) {
        //base
        if(n == 0)
            return 1;
        //logic
        double temp = myPow(x,n/2);
        if(n%2 == 0){
            return temp * temp;
        }
        else{
            if(n > 0)
                return temp * temp * x;
            else return temp * temp * (1/x);
        }
        
    }
};