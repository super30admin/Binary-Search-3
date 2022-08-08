//Time Complexity- O(log n)
//Space Complexity- O(log n)
//Successfully ran on leetcode

class Solution {
 public double myPow(double x, int n) {
     
     if(n==0) return 1.0;
     
     double result = myPow(x , n/2);
     
     if(n%2==0){
         return result* result;
     }
     else
         if(n>0){
         return result*result*x;
         }
     
         else return result* result* 1/x;        
 }
}