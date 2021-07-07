//Time Complexity-O(logn)
//Space Complexity-O(1) if recursive stack space is not considered or else it is O(logn) but this method can still be 
// optimized and I have uploaded the iterative approach as well
// Did the code execute on Leetcode? Yes

class Solution {
public:
    double myPow(double x, int n) {
       if(n==0)
       {
           return 1.0;
       }
        long int a=n;
        if(a<0)
        {
            x=1/x;
            a=-a;
        }
       double temp=myPow(x,a/2);
        if(a%2==0)
        {
            return temp*temp;
        }
        else
        {
            return temp*temp*x;
        }
    }
};