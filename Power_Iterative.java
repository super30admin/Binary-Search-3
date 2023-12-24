// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class Power_Iterative {
    public double myPow(double x, int n) {

      double result =1;
      if (n==0) return 1;

      if(n < 0) {
        n = n*-1;
        x= 1/x;
      }

      while(n!=0){

        if(n %2 !=0 ){
          result =  result *  x;
        }

        n=n/2;
        x=x*x;
      }
      return result;
    }
  }
