// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Consider the n as binary, The power of x keep increasing, as in currentProduct
// Whenever we see 1 bit we can multiply the answer to the current product.
//When iteration is over we will get our result
class Solution {
    public double myPow(double x, int n) { 
        long N = n;
        if(n < 0){
            N = -N;
            x = 1/x;
        }
        double ans = 1;
        double currentProduct = x;
        
        while(N > 0){
            
            if(N%2 == 1){
                ans *= currentProduct;
            }
            N /=2;
            currentProduct *= currentProduct;
        }
            
        return ans;
    }
}