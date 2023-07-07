/*
// Time Complexity : O(log(n))
// Space Complexity : O(log(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
any odd exponent can be written as even exponent square + 1 exponent
any even exponent can be wriiten as even exponent 
and Since these exponent are calculated twice we can calucale them just once, hence decreasing time
logarithmically as it is for every half exponent
*/

//recursive solution.

#include<iostream>
#include<vector>
#include<queue>

using namespace std;

class Solution {
    double helper(double x, int n){
        if(n==0) return 1;
        double temp = helper(x,n/2);
        if(n%2 == 0) return temp*temp;
        else return temp*temp*x;
    }
public:
    double myPow(double x, int n) {
        if(n<0){
            x = 1/x;
            n = abs(n);
        } 
        return helper(x,n);
    }
};



/*
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
any odd exponent can be written as even exponent square + 1 exponent
any even exponent can be wriiten as even exponent 
and Since these exponent are calculated twice we can calucale them just once, hence decreasing time
logarithmically as it is for every half exponent
*/

//iterative solution

class Solution {
public:
    double myPow(double x, long long int n) {
    if(n==0) return 1;
    if(n<0) {
        n = -n;
        x = 1/x;
    }
    double ans = 1;
    while(n>0){
        if(n&1 !=0) ans *= x;
        x *= x;
        n >>= 1;
    }
    return ans;
    }
};