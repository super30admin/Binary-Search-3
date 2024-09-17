//time complexity:O(logn)
//space complexity:O(logn)
//executed on leetcode: yes
//approach:using binary search
//any issues faced? no

class Solution {
public:
    double myPow(double x, int n) {
        long long N=n;
        if(N<0)
        {
            x=1/x;
            N=-N;
        }
        return power(x,N);
    }
    double power(double x, long long N)
    {
        if(N==0)
            return 1.0;
        double temp=power(x,N/2);
        if(N%2==0)
            return temp*temp;
        else
            return temp*temp*x;
    }
};