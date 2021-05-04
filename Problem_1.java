//Time complexity: O(log(n))
//Space Complexity: O(1)

class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        double y= myPow(x,n/2);
        if(n%2==0){
            return y*y;
        }else {
            if(n<0){
                return y*y*(1/x);
            }else return y*y*x;
        }
    }
}