//iterative
//time: O(logn)
//space: O(1)
class Solution {
public:
    double myPow(double x, int n) {
        double result = 1.0;
        long long N = n;
        if(N < 0) {
            x = 1/x;
            N = N*-1;
        }
        while(N != 0) {
            if(N%2 != 0) {
                result = result*x;
            }
            x = x*x;
            N = N/2;
        }
        return result;
    }
};

//recursive
//space: O(logn) - recursive stack
/*
class Solution {
public:
    double myPow(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        double result = myPow(x, n/2);
        if(n%2 == 0) {
            return result*result;
        }
        else {
            if(n < 0) {
                return result*result*(1/x);
            }
            else {
                return result*result*x;
            }
        }
    }
};
*/