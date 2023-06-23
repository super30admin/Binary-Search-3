// TC:O(logN)
// sc:o(1)

// Approach is to find the small chunks first if power =n then-->n/2--->n/4--->1-->0

class Solution {
    public double myPow(double x, int n) {
        if(n==0)
        return 1;

        double ans=myPow(x,n/2);
         
        if(n%2==0)
        {
            // Even power(pos/neg) case
            return ans*ans;
        }
        else
        {

            if(n>0)
            // odd pos power case
            return ans*ans*x;
            else
            // odd neg power case
            return ans*ans*1/x;
        }
    }  
}

