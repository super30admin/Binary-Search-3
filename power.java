class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
        {
            return 1.0;
        }
        double temp = myPow(x, n/2);
        if(n % 2 == 0)
        {
            return temp * temp;
        }
        else
        {
            if(n % 2 != 0 && n > 0)
            {
                return temp * temp * x;
            }
            else
            {
                return temp * temp *1/x;
            }
        }
    }
}
