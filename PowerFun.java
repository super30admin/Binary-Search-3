/*
Desc : We recurse for half of the specified power times and multiply it to itself, if the power is odd we use an extra multiplication operation
else we return it as is.
Time Complexity : O(log(n))
Space Complexity : O(1)
*/

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        double temp = myPow(x,n/2);
        if(n%2 == 0){
            return temp*temp;
        }else{
            if(n>0){
                return temp*temp*x;
            }else{
                return temp*temp*1/x;
            }
        }
    }
}
