/*
 * #50. Pow(x, n)
 * 
 * Implement pow(x, n), which calculates x raised to the power n (i.e. xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104

 */


/*
 * Time Complexity: O (log N) -> Since, we are making recursive calls on n/2 everytime until we hit the base case, time for execution is O (log N)
 * 
 * Space Complexity: O (log N) -> because we will have log N( since we are doing n/2 everytime) frames in recursive stack
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.binarysearch3;

public class XPowN {
	
	public double myPow(double x, int n) {
        
        // #1. Base case
        if(n == 0){
            return 1;
        }
        
        // #2. Bottom-up recursion
        
        // Recursive case
        
        // Recursion on n -> n/2 until we hit the base case, where n == 0, return 1 as recursive value to previous stack frame based on n is odd(n is positive or negative) or even. Repeat the step at each level until recursive stack becomes empty
        double recurrVal = myPow(x, n/2);
              
        // conditional statements
        // Here, recurrVal refers to recursive value from previous stack frame
        
        // If n is even
        if(n % 2 == 0){
            return recurrVal * recurrVal;
        }
        // If n is odd
        // The answer will change only when n is odd for negative value of n
        else{
            // Check if n is negative
            if(n < 0){
                return recurrVal * recurrVal * 1/x;
            }
            // If n is positive
            else{
                return recurrVal * recurrVal * x;
            }
        }
        
    }

}
