// Time Complexity :O(log n)
// Space Complexity :O(log n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: using recursion we check if the power is even,odd or root. if its even recursion untill the power becomes 0 else for odd multiply by x at the end 


class Solution {
    public double myPow(double x, int n) {
        if( n == 0) return 1;
       double result = myPow(x, n/2 );
        if( n%2 == 0 ){
            return result * result;
        } else {if( n < 0){
           return  result * result * (1/x);
        } else return result*result*x;
}
     
    }
}