// Time Complexity : O(log(n))
// Space Complexity : O(log(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
    double helper(double x, long long n) {
        if (n == 0) return 1;
        if (n<0) return 1.0/(helper(x, -n));
        if (n%2 == 1) return x*(helper(x*x, (n-1)/2));
        else return helper(x*x, (n/2));
    }
    double myPow(double x, int n) {
        return helper(x, n);
    }
};