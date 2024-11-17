// sol1 :
// handle constraints : n =0,1 and x =0 and n < 0
// also n is passed as first and last range of integer

//soln2: recurssive approach
//divide n by 2 and then put it back together
//also if n/2 is not equal to 0 (that is it is odd) -> multiply once with x again
// TC : O(log n),  SC : O(log n)
// write the code again

//soln 3: Iterative approach
// TC : O(log n) , SC: O(1)

class Solution {

  public double myPow(double x, int n) {
    //base
    if (n == 0) return 1;
    if (n == 1) return x;
    if (x == 0) return 0;

    //constraints
    //because of how the if condition is designed we don't need to handle this
    // n is always going to be an integer and never a decimal number
    // when we mod negative number by 2, we get absolute integer result
    // we multiply it that many times and divide in the end by 1
    // looking at the else condition we will come to a point where n is either 1 or

    if (n < 0) {
      if (n == Integer.MIN_VALUE) {
        n += 2;
      }

      x = 1 / x;

      n = -n;
    }

    return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
  }
}
