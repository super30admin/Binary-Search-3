/**
 * Time: O(log n) where n -input n
 * Space: O(log n) stack size
 */
class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0) return 1;
        //cases
        double temp = myPow(x,n/2);

        if(n%2 == 0) return temp*temp;
        else{
            if(n<0) return temp*temp*1/x;
            else
                return temp*temp*x;
        }
    }
}