class Solution {
public:
    double myPow(double x, int n) {

        // base case where n is 0, x^0 is always 1
        if (n==0){
            return 1;
        }

        // recursive case where we divide the problem into smaller subproblems
        // we return the result  with n divided by 2
        double res = myPow(x, n/2 );

        // if n is even, we return res * res
        if (n % 2 == 0){
            return res * res  ;
        }
        // if n is odd, we return res * res * x
        // we check if n is positive or negative to handle the case where n is negative
        else{
            if (n>0){
                return res * res *x ;
            }
            // if n is negative, we return 1/(res * res * x)
            else{
                return res * res * 1/x;
            }
        }
        
        
    }

};