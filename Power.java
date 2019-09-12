public class Solution {
    public double myPow(double x, int n) {
       
        
        if(n==0)    // If N is 0 eg : (2,0) -> return 1 as 2^0 =1.
            return 1;
      
        double temp = myPow(x,n/2);
        
        if(n%2==0)      // If n is even eg: (2,8)  
        {
            return temp*temp;
        }
        else
        {
            if(n>0) return temp*temp*x;     // if n is odd eg: (2,3) 
            else
                return temp*temp/x;     // if n<0 eg : (2,-4) 
        }
        
    }
}