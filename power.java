//Time complexity-O(logn)
//Space complexity-O(logn)
//Ran on leetcode-Yes
//Solution with comments-

class Solution {
    public double myPow(double x, int n) {

        if(n<0){
                n=Math.abs(n);
                x=(1/x);
            }
        
       return product(x,n);
    }
    
    public double product(double x, int n){
       if(n==0) return 1;
        
        double prod= product(x,n/2);//finding the power/2 for the number everytime to decrease number of mutlplication
        if (n % 2 == 0) 
            return prod*prod;
        else 
            return prod * prod * x;
        
    }
}