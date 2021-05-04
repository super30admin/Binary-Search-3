
//Recursion -
//Time Complexity - O(logn)
//Space Complexity - O(1) - for recursion stack O(logn)
class Solution {
  public double myPow(double x, int n) {

    if(n == 0){
      return 1;
    }

    double y  = myPow(x, n/2);
    //System.out.println("y: "+y+" n: "+n);

    if(n % 2 == 0){
      // System.out.println("if");
      return y*y;
    }
    else{
      // System.out.println("else");
      if(n < 0){
        return y*y*(1/x);
      }
      else{
        return y*y*x;
      }
    }
  }
}


//Brute Force Method - gives time limit exceeded issue:
//Time Complexity - O(n)
//Space Complexity - O(1)
class Solution {
  public double myPow(double x, int n) {

    double result = 1.0;

    if(n < 0){
      x = 1/x;
      n = n*-1;
    }
    for(int i=1; i<=n; i++){
      result = result * x;
    }
    return result;
  }
}
