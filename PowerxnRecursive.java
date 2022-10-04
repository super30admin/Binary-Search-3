class Solution {
    //tc = o(logn)
    public double myPow(double x, int n) {
        //base case
        if(n== 0) return 1.00;
        //logic
        double result = myPow(x,n/2);
        if(n%2 == 0)//even
        {
            return result * result;
        }
        else
        { // odd
            if(n>0) return result * result * x; 
            return result * result *(1/x);
        }

     
    }
}