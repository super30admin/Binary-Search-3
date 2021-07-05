//Iterative approach
//Time Complexity:O(logN)
//Space Complexity:O(1)
//In this approach, I'll be convering x to its inverse and make N positive, if the given N is negative. Otherwise, I'll be iteratibvely computing the cur product and update the resultant pow variable when ever I encounter an odd power.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
        long N=n;
       
        if(N<0){
             x=1/x;
             N=-N;
        }
        double pow=1;
        double cur=x;
        for(long i=N;i>0;i/=2){
            if((i%2)==1){
                pow=pow*cur;
            }
            cur=cur*cur;
        }
        return pow;
    }
}
//Recursive approach
//Here, I'll be repeating the same things in a recursive manner, by using divide and conquer approach.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public double myPow(double x, int n) {
      if(n==0){
          return 1.0;
      }
      if(n<0){
          if(n==Integer.MIN_VALUE){
              n+=2;
          }
          x=1/x;
          n=-n;
      }
       return (n%2==0)? myPow(x*x,n/2):x*myPow(x*x,n/2); 
    }
}