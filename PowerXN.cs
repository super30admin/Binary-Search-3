using System;
namespace Algorithms
{
    public class PowerXN
    {
        /// Time Complexity : O(Logn)
        // Space Complexity :O(n)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        public double MyPow(double x, int n)
        {
            //base
            if (n == 0) return 1.0000;
            double result = MyPow(x, n / 2);
            if (n % 2 == 0)
            {
                result = result * result;
            }
            else
            {
                if (n < 0)
                {
                    result = result * result * 1 / x;
                }
                else
                {
                    result = result * result * x;
                }
            }
            return result;
        }
    }
}
