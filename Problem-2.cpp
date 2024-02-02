// Time Complexity : O log(n)

// Space Complexity : O(N) - recursion stack

// Did this code successfully run on Leetcode : YES

// Appoarch: Using recursion, halfing n value.

// 50. Pow(x, n)

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    double myPow(double x, int n) {
        if(n==0) return 1.0;
        double re = myPow(x,n/2);
        if(n%2 == 0){
            return re*re;
        }
        else{
            if(n<0){
                return re*re*1/x;
            }
            else{
                return re*re*x;
            }
        }
    }
};