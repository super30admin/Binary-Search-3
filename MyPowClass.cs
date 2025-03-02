// TC -> O(logn)
// SC -> O(1);

public class Solution
{
    public double MyPow(double x, int n)
    {
        if (n == 0)
        {
            return 1.0;
        }
        var y = MyPow(x, n / 2);

        if (n % 2 == 0)
        {
            return y * y;
        }
        else
        {
            if (n < 0)
            {
                return y * y * 1 / x;
            }
            else
            {
                return y * y * x;
            }
        }
        return 1;
    }
}