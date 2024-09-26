// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//This problem is solved using recursion.

class Solution {
public:
    double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double t1 = myPow(x,n/2);
        if(n%2==0){
            return t1*t1;
        }
        else{
            if(n<0){
                return t1*t1*(1/x);
            }else{
                return t1*t1*x;
            }
        }
    }

};
