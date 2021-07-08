// Time Complexity : O(logn)
// Idea is to have the binary search like divide and conquer startegy.
// Here we divide the value of the power i.e. m

class Solution {
    public double myPow(double x, int m) {
        
        double temp=x;
            if(m==0)
            return 1;
            temp=myPow(x,m/2);
            if(m%2==0)
            return temp*temp;
            else 
            {
            if(m > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
            }
    }
}
