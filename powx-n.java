class Solution {
    public double myPow(double x, int n) {
      
      if(n ==0) return 1.00;
      double result = myPow(x,n/2);
      if(n%2==0){
          result = result * result;
      }
      else if ( n >0){
         return  result * result * x;

      }
      else{
          return result * result * 1/x;
      }

        return result;
    }

}



/***

Brute Force : O(N)

Approach : Iterating till N in a for loop by multiplying result with x;


Binary Search : logn

Approach : Using recusion, deviding the n/2 till n = 0. When stack.pop happens under the hood, checking whether n%2 is equal to 0. Then multiplying result with result bcz even powers are nothing but multiplication of previous result(2^4 = 2^2 * 2^2). If n%2 == 1 the n is odd. so, if n is positive multiply result with result and x. If it negitive multiply result with result and 1/x. (2^5 = 2^2 * 2^2 * 2), (2^-5 = 2^-2 * 2^-2 * 1/2). 

Iterative Method : 

Creating one stack and adding all the n/2's  inside stack. Poping each n/2 out and checking the above operations.


 */