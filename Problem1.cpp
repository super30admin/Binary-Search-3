//
// Created by shazm on 8/14/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
    double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double temp = myPow(x,n/2);
        if(n%2==0){
            return temp*temp;
        }else if(n>0){
            return x*temp*temp;
        }
        return (temp*temp)/x;
    }
};