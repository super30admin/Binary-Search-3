class Solution {
    //logrithmic solution
    //O(log n)
    //O(Log n)
    //recursion
    public double myPow(double x, int n) {
        
       //base
       if(n == 0) return 1.0;

        //logic
        double re = myPow(x,n/2);
        if(n%2 == 0){
            return re*re;
        }else{
            if(n < 0) return re*re*(1/x);
            else return re*re*x;
        }
    }
}