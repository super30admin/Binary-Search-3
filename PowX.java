//Time Complexity :O(Log(n)).
//Space Complexity :O(1) + recursion stack
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class Solution {
    public double myPow(double x, int n) {
        if(0 == n){return 1.0;}
        if(1 == n){return x;}
        if(x > 1.0 && n == Integer.MIN_VALUE){return 0.0;}
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        double result;
        double res = myPow(x,n/2);
        if(n%2 == 0){
            result = res*res;
        }else{
            result = x*res*res;
        }
        return result;
    }
}