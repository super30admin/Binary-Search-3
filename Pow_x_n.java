class Solution {
    //Approach: 1. Here I have done recursion, wherein the myPow function is called recursively with n/2 on each call, 
	//such that when the x pow n where n becomes zero will return 1 and start building the answer form there.
	//2. if n is even we just multiply the function twice but if its odd, we multiple x or 1/x based on even or odd correspondingly.
    public double myPow(double x, int n) {
        //base case
        if(n == 0)
            return 1;
        //logic - recurse
        
        double halfFunction = myPow(x, n/2);
        if(n%2 == 0)
        {
            return halfFunction * halfFunction;
        }else
        {
            if(n < 0)
            {
                return halfFunction * halfFunction * (1/x);
            }else
            {
                return halfFunction * halfFunction * (x);
            }
        }        
    }
}

//Time Complexity : O(log n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :