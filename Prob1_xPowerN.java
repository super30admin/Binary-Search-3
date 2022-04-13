

// Time Complexity : O(Log N base 2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public double myPow(double x, int n) {
        if(n == 0)  return 1.00;
        
        double result = myPow(x, n/2); // Reducing the power by 2(Half)
        if(n %2 == 0)  return result * result; // If power is in even
        else{
            if(n > 0){
                return result * result * x; // n is odd and > 0
            }else{
                return result * result * (1/x); // n is odd and < 0
            }
        }
    }
}



