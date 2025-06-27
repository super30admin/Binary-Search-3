// Time complexity - O(log n)
// Space - O(log n)
// Solve on leetcode - yes
// faced any issues - no
// Initially, we are chceking for negative values of n to change from x to 1/x. Then for every value of n we are doing pow(n/2)*pow(n/2). Instead of calling same function multiple times just storing in constant to reduce the recursive stack
class Solution {
    public double myPow(double x, int n) {
       long N = n;  
         if(n<0){
         if(n==Integer.MIN_VALUE){
             n+=2;
         }
         x=1/x;
         n=-n;
     }
        if(n==0) {
            return 1;
        }
        double p =  myPow(x, n/2);
        return (n%2==1) ? x* p*p : p*p;
    }
}
