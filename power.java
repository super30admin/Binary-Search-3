class Solution {
    public double myPow(double x, int n) {
        // recursive solution-recursively call mypow with n/2 and if n is even , do res* res else
        //do res*res*x , base case is when n=0
        // TC-O(logn), SC-O(1)
        if (n==0){
            return 1.00;
        }
        double result = myPow(x, n/2);
        if(n%2==0){
            return result*result;
        }
        else{
            if (n>0){
                return result*result*x;
            }
            else{
                return result*result*1/x;
            }
        }
    }
}