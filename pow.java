//approach-we are cutting the value of n in half at each iteration and multipling x by itself. if the n is odd then we multipy the result with x before cutting the n and multipling the x.that way we are keeping the result consistent i.e when cutting a odd number by 2 (5/2=2-->2+2+1)ands we are missing that 1 x factor if we dont multiply x with result.
//time complexity-O(logn)as we are cutting the calculations in half at each iteration
//space complexity-O(1)
class Solution {
    public double myPow(double x, int n) {
        double res = 1;
       
         if (n < 0) {
            x = 1 / x;
        }
        while (n != 0) {
            if (n % 2 != 0) res = res * x;
            n = n / 2;
            x = x * x;
        }
        return  res;
    }
}
