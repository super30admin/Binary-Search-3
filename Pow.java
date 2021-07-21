class Solution {
    //Time O(logN)
    //Space O(1)
    public double myPow(double x, int n1) {
        long n = n1;
        if(n < 0)
        {
            x = 1/x;
            n = -n;
        }
        double res = 1;
        while(n > 0)
        {
            if(n % 2 == 1)
            {
                res = res * x;
            }
            x = x * x;
            n = n/2;
        }
        return res;
    }
}