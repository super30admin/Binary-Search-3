// Time Complexity : Log (n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * If the number is raised to a negative value, we change it to 1/x.
 * If the number is odd, we multiple result with the number itself, else we multiply the number by the number itself and half the number for the next iteration.
 *
 */

class Problem1 {
    public double myPow(double x, int n) {
        double result = 1.0;
        if(n < 0){
            x = 1/x;
            n = n * -1;
        }
        while(n != 0){
            if(n % 2 != 0){
                result = result * x;
            }
            x = x * x;
            n = n/2;
        }
        return result;
    }
}