#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
First we check if n is less than zero, if it is we store x as 1/x
We then take loop while n is not zero check if n is not even we store the product of
ans and product and assign n as n/2 and x as x*x and then we return the answer
*/
class Solution{
public:
    double myPow(double x, int n){
        if(n<0) x=1/x;
        double ans = 1.0;
        while(n!=0){
            if(n%2 != 0) ans *= x;
            n=n/2;
            x *= x;
        }
        return ans;
    }
};
