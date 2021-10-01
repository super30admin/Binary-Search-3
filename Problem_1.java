// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// recursively call the same function and return the product of result, also take care of negative case
// Your code here along with comments explaining your approach
class Solution {
    public double myPow(double x, int n) {
        //base
        if( n == 0 ) return 1;
        //logic
        double result = myPow(x,n/2);
        if( n % 2 == 0){
            return result * result ;
        }else{
            if(n > 0){
                return result * result * x;
            } else{
                return result * result * 1/x;
            }
        }
    }
}

