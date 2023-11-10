// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class Pow {
    class Solution {
        public double myPow(double x, int n) {
            // //base
            // if(n == 0)
            //     return 1.00;

            // //logic
            // double result = myPow(x, n/2);

            // if(n % 2 == 0){
            //     return (result * result);
            // }
            // else{
            //     if(n > 0)
            //         return(result * result * x);
            //     else
            //         return(result * result * 1/x);
            // }

            double result = 1.0;
            if(n > 0){
                while(n > 0){
                    if(n % 2 != 0){
                        result = result * x;
                        n--;
                    }
                    x *= x;
                    n /= 2;
                }
            }
            else{
                while(n != 0){
                    if(n % 2 != 0){
                        result = result * (1/x);
                        n++;
                    }
                    x *= x;
                    n /= 2;
                }
            }
            return result;
        }
    }
}
