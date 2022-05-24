/* 
    Time Complexity                              :  O(Log n)
    Space Complexity                             :  O(Log n) - due to recursion stack
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  



class Solution {
public:
    double myPow(double x, int n) {
        long long N = n;
        if(N < 0) {
            x = 1/x;
            N = -N;
        }
        return mpow(x, N);
    }
    
    double mpow(double x, long long n) {
        if(n == 0) return 1.0;
        
        double half = mpow(x, n/2);
        if(n % 2 == 0) {
            return half*half;
        } else {
            return half*half*x;
        }
    }
};