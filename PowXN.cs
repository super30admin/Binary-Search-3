using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public class PowXN
    {
        /**
         * T.C: O(LogN) we are dividing each time the power to get result
         * S.C: O(1) since no extra space used
         * 
         */
        public double MyPow(double x, int n)
        {

            //base
            if (n == 0)
                return 1;

            //logic
            double result = MyPow(x, n / 2);
            //when power is even number
            if (n % 2 == 0)
            {
                return result * result;
            }

            //when poser is odd number
            else
            {
                //power is +ve
                if (n > 0)
                {
                    return result * result * x;
                }
                //power is -ve
                else
                {
                    return result * result * (1 / x);
                }
            }

        }
    }
}
