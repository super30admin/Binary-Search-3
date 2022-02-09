public class powxN {
    /*
         // Time Complexity : O(2^n)
         // Space Complexity : O(n)
    */
    class Solution {
        //recurse
        public double myPow(double x, int n) {
            if(n==0) return 1.0000;
            double result = myPow(x,n/2);

            if(n%2==0) {
                result = result * result;
            }
            else{
                if(n>0)
                    result = result * result *x;
                else
                    result = result * result *1/x;
            }
            return result;
        }
    }
}
