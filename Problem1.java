// Time Complexity :O(log N)  
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach;
// 1. If power is 0 return 1 , if power is 1 return x.
// 2. If power is even then find power(x,n/2) and multiply it with it again to get power(x,n). Do this till n reaches 1 and folow step 1.
// 3. If power is odd then find power(x,n/2),multiply this with itself and with x to get power(x,n).Do this till n reaches 1 and folow step 1.
// 4. If n is negative then we need to find(1/xˆn) so we can call power(1/x,-n) and follow steps 1,2,3.
class Solution {
    public double myPow(double x, int n) {
        if(x == 0)  return 0;
        if(n == 0)  return 1;
        if(n>=0)    return powered(x,n);
        return powered(1/x,-n);
            
        
    }
    public double powered(double x,int n){
        if(n==0)    return 1;
        if(n==1)    return x;
        if(n%2==0) {
            double y = powered(x,n/2);
            return y*y;
        }
        else{
            double y = powered(x,n/2);
            return y*y*x;
        }
    }
}
