// Time complexity - 0(logn)
// space complexity - 0(logn)
// code successfully executed on leetcode

class Solution {
    public double myPow(double x, int n) {
        long N =n;
        if(N<0){
            x =1 /x;
            N=-N;
        }
        double ans = 1;
        double CP = x;
        for (long i=N;i>0;i/=2){
            if((i%2==1)){
                ans = ans * CP;
            }
            CP = CP * CP;
        }
        return ans; 
    }
}