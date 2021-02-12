// Time Complexity :O(logn)
// Space Complexity :O(logn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :getting started

// Your code here along with comments explaining your approach

public class PowXN {
    class Solution {
        public double myPow(double x, int n) {
            double res = 1.0;
            long N = n;

            if(n<0){
                x = 1/x;
                N = -N;// writing as N = -n may cause integer overflow
            }

            //perform binary search to find power
            double currentProduct = x;
            for(long i = N; i>0; i /= 2){
                if(i %2 == 1){
                    res *= currentProduct;
                }
                currentProduct *= currentProduct;
            }
            return res;
        }
    }



}
