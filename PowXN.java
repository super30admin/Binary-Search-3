// Time Complexity : 0(log n) for recurssion
// Space Complexity : 0(log n) for recurssive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class PowXN {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        //recurssion by doing n/2 everytime
        double temp = myPow(x, n/2);
        if(n % 2 == 0){
            return temp * temp;
        }
        else{
            if(n < 0){
                return temp*temp*(1/x);
            }else{
                return temp*temp*x;
            }
        }
    }
}