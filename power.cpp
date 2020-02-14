//Time Complexity-O(logn)
//Space Complexity-O(1)
//Did the code run on Leetcode ? Yes

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
        double y=1.0;
        double curr_prod=x;
        for(long int i=a;i>0;i=i/2)
        {
            if(i%2==1)
            {
                y=y*curr_prod;
            }
            curr_prod*=curr_prod;
        }
        return y;
    }
};