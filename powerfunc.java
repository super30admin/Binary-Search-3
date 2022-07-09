class Solution {
    //Time complexity: O(logn)
    //Space complexity: O(1)
    public double myPow(double x, int n) {
        if(n==0)
            return 1.000;
        double res=myPow(x,n/2);
        if(n%2==0)
            return res*res;
        else{
            if(n<0)
                return res*res*(1/x);
            else
                return res*res*x;
        }
    }
}