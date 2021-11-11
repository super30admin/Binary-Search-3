//Timecomplexity:- o(logn).
//spacecomplexity:-o(logn) for reccursion stack.
//Did it run on leetcode:- yes.
//What problems did you face?;- initially missed some cases.
//Your approach with code:- when n is even just returning x^(n/2)*x^(n/2), if odd one extra x multipled to x^(n/2)*x^(n/2) 
//is returned ,if n<0 returning with1/x multiplied to it .so this done reccursively until n==0 and finally 1 is returned.

class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
        double cacheresult=myPow(x,n/2);
        if(n%2==0){
            return cacheresult*cacheresult;
        }
        else{
            if(n<0){
                return cacheresult*cacheresult*1/x;
            }
            else{
                return cacheresult*cacheresult*x;
            }
        }
    }
}