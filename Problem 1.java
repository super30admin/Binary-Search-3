//Time Complexity: O(log n)
//Space Complexity: O(n) for recursive stack space

//Successfully runs on leetcode: 0 ms

//Approach: We are recursively dividing n by 2 and finding the solution
//of the base cases and consecutively multiplying those results 
//for higher n's

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double temp = myPow(x,n/2);
        
        if(n % 2 == 0)
        {
            return temp * temp;
        }
        else
        {
            if(n < 0)
                return temp * temp * 1/x;
            else
                return temp * temp * x;
        }
    }
}