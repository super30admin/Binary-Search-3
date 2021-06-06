//Time complexity O(log(n))
//Space complexity O(n/2)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
   
    public double myPow(double x, int n) {
        
     
        if(n == 0){
            return 1.0;
        }
     
        double temp = myPow(x, n/2);
        
      
        //base case
        //logic
         if(n % 2 == 0){
           
         return  temp * temp ;
       }
        else {
              if(n > 0){
                  
                 return temp * temp * x ; 
                  
              }
             else{
           
           return temp * temp * 1/x ;
       }
            
        }
    }

}