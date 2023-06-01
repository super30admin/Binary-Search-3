// Time Complexity : O(logn)
// Space Complexity : O(1) for iterative approach, O(logn) if recursive approach is used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// solution 1

class Solution {
public:
    double myPow(double x, int n) {
        if(n == 0) return 1;
        double result = myPow(x,n/2);
        if(n%2 == 0)
        {
            result = result*result;
        }
        else
        {
            if(n>0)
            {
                result = result*result*x;
            }
            else{
                result = result*result*1/x;
            }
        }
        return result;
    }
};

// solution 2

class Solution {
public:
    double myPow(double x, int n) {
        double ans = 1;
        int p = n;
        while(n!=0)
        {
            if(n&1){
                ans = ans*x;
            }
            x = x*x;
            n = n/2;
        }
        if(p>0) return ans;
        return 1/ans;
    }
};


// solution 3

class Solution {
public:
    double myPow(double x, int n) {
        double ans = 1;
        long long p = n;
        if(p<0)
        {
            p=-p;
            x=1/x;
        }
        while(p!=0)
        {
            if(p&1){
                ans = ans*x;
            }
            x = x*x;
            p = p>>1;
        }
        return ans;
    }
};