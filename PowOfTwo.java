
// Time Complexity : o(logN)
// Space Complexity :o(logN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
/*Approach
1) here we use recursion to reduce the time complexity
2) we kow pow(2,5)= pow(2,4) * pow(2,1)
3) Thus we cn split 2^4 as 2^2 * 2^2 until we reach 2^0 where n == 0
4) once we do that, we need to check if n is even then the factors would be even if 
-> 2^6-> 2^2 * 2^2 * 2^2
5) if n is odd, then we have odd factors with y*y*x
-> 2^5 -> 2^2 * 2^2 * 2^1
if n is negative
-> then we can have y*y*1/n
as -n -> 1/n



*/

public class PowOfTwo {
    
    public double myPow(double x, int n) {
        
        //base case
        if(n==0)
            return 1;
        
        //logic
        double y= myPow(x,n/2);
        
        if(n%2==0)
        {
            return y*y; 
        }
        else
        {
            if(n>0)
            {
                return y*y*x;
            }
            else
            {
                return y*y*1/x;
            }
        }
        
        
        
        
        
    }


}
