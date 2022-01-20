//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;

class Solution {
public:
    double myPow(double x, int n) {
        if(n==0)
        {
            return 1;
        }
        double result=myPow(x,n/2);
        if(n>=0)
        {
            if(n%2==0)
            {
                return result*result;
            }
            return result*result*x;
        }
        else
        {
            if(n%2==0)
            {
                return result*result;
            }
            return result*result*(1/x);
        }
    }
};