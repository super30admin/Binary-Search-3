//TC: log(n)
//SC: log(n)
class Solution {
    public double myPow(double x, int n) {
        double output = dfs(x,n);            
        if(n<0)
            return 1/output;
        return output;				//Using DFS method to square every time.
    }								//DFS is done as follows
									//Recalling dfs method untill reaching n 0, returns 1.
    double dfs(double x, int n)		//After that doing a square to the number returned, if the number is odd multipling it to x.
    {								//this returns pow(x,n)
        if(n==0)					//if the power is -ve, return 1/result, result.
            return 1;
        double temp = dfs(x,n/2);
        if(n%2==0)
            return temp*temp;
        else
            return temp*temp*x;
    }
}