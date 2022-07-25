/*
This solution uses a divide and conquer approach to solving the power function. It recurively computes the function.

Did this code run on leetode: Yes
*/
class Solution {
    //Time Complexity: O(log(n))
    //Space Complexity: O(1)
    public double myPow(double x, int n) {
        
        if(n == 0)
            return 1.000;
        
        double result = myPow(x, n/2);
        //If the power is an even power, then we only need to return the product of the two divided halves
        if(n % 2 == 0)
            return result * result;
        
        //If the power is an odd power, then need to return the product of the two divided halves and the number x
        else
        {
            if(n > 0)
                return result * result * x;
            else
                return result * result * 1/x;
        }
    }
}