//Time Complexity : O(logn) n is the power
//Space Complexity : O(h) height of the recursive stack
//Leetcode: Worked

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n==0) return 1;
        
        //logic
        if(n%2 == 0){
           return myPow(x*x,n/2);
        }
        else{
            if(n<0)return myPow(x*x,n/2) * 1/x;
            else return myPow(x*x,n/2) * x;
            
        }
    }
}