//Space : O(1)
//Time : O(log N)

class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        
        double result = myPow(x , n/2);
        if(n%2 == 0) return result*result;
        if(n<0) return result*result*1/x;
        else return result*result*x;
        
    }
}