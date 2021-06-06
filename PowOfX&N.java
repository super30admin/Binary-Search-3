//Time: log(n), where n is the power of x
//space: log(n), recursive stack
class Solution {
    public double myPow(double x, int n) {

        //base
        //if reaches the base case
        if(n==0) return 1.0;
        double res = myPow(x, n/2);
        //logic
        //if n is even
        if(n%2 == 0){
            return res * res;
        }//if n is odd
        else{//if n is positive
            if(n>0){
                return res * res * x;
            }//if n is negative
            else{
                return res * res * (1/x);
            }
        }
    }
}