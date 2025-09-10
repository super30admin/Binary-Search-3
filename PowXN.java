class Solution {
    //Idea is to make the number half at each step and then use recursion to construct the solution
    //Time Complexity: O(logn)
    //Space Complexity:O(logn) 
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        double temp = myPow(x,n/2);
        if(n%2==1)
        {
            return temp*temp*x;
        }
        else if(n%2==-1)
        {
            return temp*temp*(1/x);
        }
        else
        {
            return temp*temp;
        }
    }
}