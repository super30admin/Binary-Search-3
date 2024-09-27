//Time Complexity=O(logn)
//Space Complexity=O(n)//recursive stack

class Solution {
    public double myPow(double x, int n) {
        if(n==0)
        {
            return 1;
        }
        double retValue=myPow(x,n/2);
        if(n%2==0)
        {
            return retValue*retValue;
        }
        else{
            if(n<0)
            {
                return retValue*retValue*1/x;
            }
            else{
                return retValue*retValue*x;
            }
        }
        
    }
}