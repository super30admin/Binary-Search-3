// Time Complexity : O(logn)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
  
using namespace std;

class Solution {
public:
    double myPow(double x, int n) {
        if(n == 0) return 1;
        
        if(n%2 != 0){
            double curr = myPow(x, n/2);
            if(n < 0){
                return curr * curr * 1/x;
            }
            return curr * curr * x;
        }
        else{
            double curr = myPow(x, n/2);
            return curr * curr;
        }
    }
};