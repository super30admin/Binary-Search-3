/*
Author : Akhilesh Borgaonkar
Problem: Implement pow(x, n), which calculates x raised to the power n.
Approach: Using recursive approach here. The Base conditions are if the power is 0 then return 1, if input is 0 then return 0,
    if power is out of Integer value bounds then add 2 to power to make it a valid Integer. The recursive function is called
    on calculation of half power of input when even power else if the power is odd then multiply the result of myPow*myPow 
    with the input x itself.
Time Complexity: O(n/2) where n is power
Space Complexity: Constant space
LC verified.
*/
class Solution {
    
    public double myPow(double x, int n) {
        //Base conditions
        if(n == 0)                  //anything to the power 0 is 1
            return 1;
        if(x == 0)                  //all powers of 0 equals 0
            return 0;
        if(n == Integer.MIN_VALUE)  //handling the edge case of Integer bound
            n += 2;
        if(n<0){                    //if the power is negative then inverse the input x because (x^-n)=(1/x)^n
            n = -n;
            x = 1/x;
        }
        double half = myPow(x,n/2); //calculating half result of power of x
        if(n%2==0)
            half = half * half;     //if even then multiply two halves 
        else
            half = x * half * half; //if odd power then, multiple two halves and x itself because (x^5 = X^2 * x^2 * x)
        return half;
    }
}