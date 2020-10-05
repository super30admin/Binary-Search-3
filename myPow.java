  
// Time Complexity :O(logN)
// Space Complexity :Recursion stack 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach




class Solution {
    public double myPow(double x, int n) {
        return recursion(x,n);
    }
    
    private double recursion(double x, int n){
        //base case 
        
        if(n == 0) return 1;
        
        double res = recursion(x, n/2);
        if(n % 2 == 0){
           res = res * res;
        }else{
             if( n < 0) 
                 return res * res * 1/x;
            
            return res * res * x;
        }
        return res;
    }
}
