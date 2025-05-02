
//TC: O(logn)
//SC: O(1)
//Iterative
class Powxn {
  public double myPow(double x, int n) {
      if(n<0){
          x=1/x;
          n=n*(-1);
      }
      double re=1.0;
      while(n!=0){
          if(n%2!=0){
              re=re*x;
          }
          x=x*x;
          n=n/2;
      }
      return re;
  }
}
/*
//Recursive
class Solution {
  public double myPow(double x, int n) {
      if(n==0){
          return 1;
      }
      double res = myPow(x,n/2);
      if(n%2!=0){
          if(n>0){
              return res*res*x;
          }else{
              return res*res*(1/x);
          }
      }else{
          return res*res;
      }
  }
}
*/