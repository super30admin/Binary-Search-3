// Time complexity O(logn)
// Space complexity O(1)
class Solution {
public:
    double myPow(double x, int n) {
        
        if (n < 0) {
            x = 1/x;
        }

        double re = 1.0;
        while (n != 0) 
        {
            if (n % 2 != 0) 
            {
                re *= x;
            }
            
            x *= x;
            n = n/2;
        }
        return re;
    }
};