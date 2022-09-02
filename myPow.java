//TC - O(logn);
//SC - O(logn);  recursive 

class Solution {
    //double res;
    public double myPow(double x, int n) {
        //res = x;
        if(n==0) return 1;
        if(n<0){
            return 1/helper(x,-n);
        }
        return helper(x,n);
    }
    
    public double helper(double x, int n){
        if(n==1 || n==0) return x;
        
        // logic
        double curr = x*x;
        if(n%2==1){
            return helper(curr,n/2)*x;
        }
        return helper(curr,n/2);
    }
}