// time complexity O(logN)
// space complexity O(1)
public class Solution
{
    public double MyPow(double x, int n)
    {
        if (n == 0)
        {
            return 1.0;
        }
        long N = n;
        if (N < 0)
        {
            x = 1 / x;
            N = N * (-1);
        }

        double cur = x;
        double res = 1;

        while (N > 0)
        {
            if (N % 2 == 1)
            {
                res = res * cur;
            }
            cur = cur * cur;
            N = N / 2;
        }
        return res;
    }
}