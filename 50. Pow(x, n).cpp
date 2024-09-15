/*
Time Complexity = O(logn)
Space Complexity = O(logn)
where n is the power of the number
*/
class Solution {
public:
    double myPow(double x,long n) {
        long num=n;
        double ans=1;
        if(n<0)
            num=(-1)*n;
        while(num)
        {
            if(num%2)
            {
                ans=ans*x;
                num-=1;
            }
            else
            {
                num=num/2;
                x=x*x;
            }
        }
        if(n<0)
            ans=(double)(1)/ans;
        return ans;
    }
};
