
/*
time complexity : O(log n), as we are reducing the power to half by recurisively calling power funciton.

algorithm:
call myPow funciton recurisvely by reducing power 'n' to half.
base case: if n reaches 0, returns 1. 

else, 
if n is even then multiply result * result
else if n is odd, multiply result * result * x;
if n < 0 then multiply result * result * 1/x;


*/

class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0){
             return  1;
        }
        
        double temp = myPow(x, n/2);
        
        if(n % 2 == 0){
            return temp*temp;
        }else{
            if(n < 0){
                return temp * temp * 1/x;
            }else{
                return temp * temp * x;
            }
        }
        
    }
}