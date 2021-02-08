Time Complexity : o(log(n))
Space Complexity: o(1)
class Solution {
    double temp = 1;
    public double myPow(double x, int n) {
        if(n == 0)
        {
            return temp;
        }
        temp = myPow(x, n/2);
        if(n % 2 == 0)
        {
            temp = temp * temp;
        }
        else
        {
            if(n < 0)
            {
                temp = temp * temp * (1/x);
            }
            else
            {
                temp = temp * temp * x;
            }
        }
        return temp;
    }
}