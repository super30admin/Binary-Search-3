// Time Complexity : O(log(n))
// Space Complexity : O(log(n))
// Did this code successfully run on Leetcode : Yes

public class Power {
  public double myPow(double x, int n) {

    if (n==0) return 1;
    double result = myPow( x, n/2) ;

    if(n < 0) x= 1/x;

    // even pow
    if(n %2 ==0 ){
      result = result * result;
    }

    //odd pow
    else{
      result =  result * result * x;
    }

    return result;
  }
}
