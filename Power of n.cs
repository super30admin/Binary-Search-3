/*
  Time complexity: O(log n)
  Space complexity: O(1)

*/

public class Solution {
    public double MyPow(double x, int n) {
        double result = 1.0;

        if(n<0)
        {
            x=1/x;
        }
        while(n!=0)
        {
            if(n%2!=0)
                result = result*x;

            x = x*x;
            n=n/2;
        }
        return result;
    }
}
