package BinarySearch3;

/*          Source Link: https://leetcode.com/problems/powx-n/
                -------------------------------------------------------------------------------------------------------
                Time complexity : o(logN) 
                space complexity: o(logN)
                Did this code run successfully in leetcode : yes
                problems faces : no
                */

public class PowOfXN {

 public double myPow(double x, int n) {

     //base
     if(n == 0) return 1.0;

     //logic
     double temp = myPow(x,n/2);

     if(n%2 == 0)
     {
         return temp * temp;
     }
     else 
     { if(n>0)
         {
         return temp * temp * x;   
         }else {
             return temp * temp * 1/x;
         }
     }
    }

}