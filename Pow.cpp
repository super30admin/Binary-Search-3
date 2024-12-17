class Solution {
public:
    double myPow(double x, int n) {
        long long pow = (long long)n;
        //result
        double result = 1.0;
        //two edge case
        if(pow == 0)
            return result;
        if(pow < 0)
        {
            x = 1.0/x;
            pow = -1.0 *pow;
        }
        // check if the n is even or odd
        // perform the square and reduce n with n/2
        while(pow)
        {
            // we need to check if n is one
            if(pow %2 == 1)
            {
                result = result * x;
                pow--;
            }
            // get x^2
            x = x*x;
            pow = pow/2;
        }
        
        return result;
    }
};
//Time complexity O(log n)
//space complexity O(1)
