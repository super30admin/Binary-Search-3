//Time Complexity: O(log n)
//Space Complexity: O(depth of recursion stack)
//Did this code run on LeetCode: Yes
//Approach: For even powers, we are recursively calling the function dividing n/2 and for odd, we must check
//whether number is positive or negative. If positive then we must multiply by x to maintain the pattern
//If negative then multiply by (1/x)

class Solution {
    public static double myPow(double x, int n) {
                //base
        if(n == 0)
            return 1.000;
        
        //logic
        double result = myPow(x,n/2);
        if(n%2 == 0)
        {
            result = result * result;
        }
        else
        {
            if(n < 0)
            {
                result = result * result * (1/x);
            }
            else
            {
                result = result * result * x;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 3)); 
    }
}