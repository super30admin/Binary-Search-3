//Time complexity : O(logn)
 
class Solution {
    public double myPow(double x, int n) {

        //base
        if( n == 0) return 1;

        double temp = myPow(x, n/2);
        if(n % 2 == 0){ // when the power to the number is even
            return temp*temp;
        }else{
            if( n < 0){ // case when power is negative
                return (temp * temp) * 1/x;
            }else{
                return (temp * temp) * x; // pwer is +ve and n is odd
            }
        }
    }
}