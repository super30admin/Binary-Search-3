class Solution {
public:
    double p = 1;
    double temp = 1;
    double myPow(double x, int n) {
        // base
        if(n == 0) return 1;
        
        // recursion logic
        temp = myPow(x, n/2);
        if((n%2) == 0) {
            p = temp * temp;
        }
        else {
            if(n > 0)
                p = temp * temp * x;
            else
                p = temp * temp * (1/x);
        }
        return p;
    }
};
