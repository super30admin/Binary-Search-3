// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : struggled with the case when mid was first index or last index


// Your code here along with comments explaining your approach

//1.Using recursive approach calculate  halfresult = power(x,n/2)
// if n is even then return halfresult * halfresult
// otherwise check if n <0 halfresult * halfresult * 1/x else halfresult * halfresult *x


class Solution {
    public double myPow(double x, int n) {
        
        if(n ==0)
            return 1.0;
        
        double half = myPow(x,n/2);
       
        if(n%2 ==0)
          return half * half; 
        else
        {   
            if(n< 0)
            {
                 return  half * half * 1/x;
            }
            else
               return  half * half * x;
        }
    }
}