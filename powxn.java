/*
 * Time Complex - O(log n) - dividing search / 2, so binary search
 * Space Complex - O(log n) - recursive , number of recursive calls
 */

class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        double result = myPow(x, n/2);
        if(n%2 == 0){
            return result * result;
        } else{
            if(n > 0){
                return result * result * x;
            } else{
                return result * result * 1/x;
            }
        }

    }
}