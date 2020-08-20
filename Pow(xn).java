Time Complexity : O(log n)
Space Complexity : O(log n)

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
            double temp = myPow(x , n/2);
        if(n % 2 == 0)
        {  return temp * temp;}
       else{
            if( n < 0){ // case when power is negative
                return (temp * temp) * 1/x;
            }else{
                return (temp * temp) * x; // pwer is +ve and n is odd
            }
        }
        
    }
}