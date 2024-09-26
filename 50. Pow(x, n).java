class Solution {// time and space of O(lg n)
    public double myPow(double x, int n) {
       
       return( n < 0 ? helper( 1/x , -n) : helper( x , n));
    }
    public double helper(double x , int n){
        //base case 
        if(n == 0)
            return 1;
        double half = helper(x , n/2) ;
        if(n%2 == 0){
            return half * half ;
        }else{
            return half * half * x ;
        }
    }
}