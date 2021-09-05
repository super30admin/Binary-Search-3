package com.s30.common.ds;
// Time Complexity : o(logn)
// Space Complexity : o(1)
class Solution {
    public static double myPow(double x, int n) {
        //base
        if(n ==0){
            return 1 ;
        }
        //logic
        if( n % 2== 0){
        return myPow(x,n/2) *  myPow(x,n/2) ;
         }
        else {
        if ( n > 0){
            return myPow(x,n/2) *  myPow(x,n/2) * x ;
        }
        else {
            return myPow(x,n/2) *  myPow(x,n/2) * 1/x ;
        }
    	}
    }
    //public static void main(String[] args) {
		// TODO Auto-generated method stub
    	//double x = 2 ;
		// int n = 4 ;
		// System.out.println("POW("+x +" , "+n+") = "+ myPow(x, n));

	}
}