//TC:O(logn)
//SC:O(1)

class Solution {
    public double myPow(double x, int n) 
    {
        
       if(n==0)
           return 1;
       else
       {
         double val = myPow(x,n/2);  
         if(n%2==0)  
           return val*val;
         else
         {
             if(n<0)
               return val*val*1/x;
             else
               return val*val*x;
             
             
         }
           
           
           
           
           
       }
        
        
        
        
        
    }
}