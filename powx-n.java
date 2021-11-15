class Solution {
    public double myPow(double x, int n) {
        
        //base
        
        if(n == 0) return 1.0;
        
        //logic
        double temp = myPow(x, n/2);
        
        if(n % 2 == 0){
            return temp * temp;
        } else if(n > 0){
            return temp * temp * x;
        } else{
            return temp * temp * 1/x;
        }
        
        
        
        
    }
}

//TC: O(log n)
//SC: o(1)
