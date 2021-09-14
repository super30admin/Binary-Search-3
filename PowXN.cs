using System;
using System.Collections.Generic;
using System.Text;

namespace Binary_Search
{
    class PowXN
    {
        //TC: O(logn)
        //SC: O(logn)
        public double MyPow(double x, int n)
        {
            //base
            if (n == 0) return 1;
            //logic
            double y = MyPow(x, n / 2);
            if (n % 2 == 0)
            {
                return y * y;
            }
            else
            {
                if (n > 0)
                {
                    return y * y * x;
                }
                else
                {
                    return y * y * 1 / x;
                }
            }
        }
    }
}
