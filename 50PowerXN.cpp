TC : O(logN)
SC : O(1)

class Solution {
public:
    double myPow(double x, int n) {
        double res = 1.0;
        if(n < 0)
            x = 1/x;
        while(n){
            if(n & 1)
                res *= x;
            x *= x;
            n /= 2;
        }
        return res;    }
};
