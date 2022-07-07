//****POWER X^N-BRUTEFORCE****
//Time complexity: o(n);
//Space complexity: o(1);
//Leetcode runnable: Y;
//Any doubts:N;
class Solution {
    public double myPow(double x, int n) {
        double result=1.000;
        //Positive
        if(n>0)
        {
           while(n!=0)
            {
                result*=x;
                n--;
            } 
        }
        if(n<0)
        {
            while(n!=0)
            {
                result*=1/x;
                n++;
            } 
            
        }
        
      return result ; 
    }
}
//****POWER X^N-OPTIMAL RECURCIVE WAY****
//Time complexity: o(logn);
//Space complexity: o(logn);
//Leetcode runnable: Y;
//Any doubts:N;


class Solution {
    public double myPow(double x, int n) {
        //Base
        if(n==0) return 1.000;
        //Logic
        double result= myPow(x,n/2);
        //Is even
        if(n%2==0)
        {
            return result*result;   
        }
        //is odd
        else
        {
            if(n<0)
            {
                return result*result*(1/x);
            }
            else
            {
                return result*result*x;  
            }
            
        } 
            
    }
}
