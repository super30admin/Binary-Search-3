class Solution {
    public double myPow(double x, int n) {
        
        // Base case 
        if(n == 0){
            return 1;
        }
        
        // Divide the problem into subproblem based on the power (even case and odd case)
        double temp =  myPow(x, n/2);
        
        // Even case
        if (n%2 == 0){
            return temp * temp;
        }
        // Odd case
        else{
            // If negative power, the result will multiplied by 1/x
            if (n >0){
                return temp * temp * x;    
            }
            else{
                return temp * temp * (1/x);
            }
        }
    }
}
}