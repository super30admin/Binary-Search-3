// Time Complexity : o(log(n))
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach: divide the n in half and calculate the value x^n/2,
  //handle three cases
    //1. integer overflow
    //2. -ve power
    //3. odd and even power(for odd power multiply x with result)

class Solution {
    public double myPow(double x, int n) {
        return  helper(x, n);
    }

    public double helper(double x, long n) {

        if(n < 0) {
            x = 1/x;
            n = -n;
        }

        if(n == 1) return x;
        if(n == 0) return 1.0d;

        double temp = helper(x, n/2);
        return  (n%2 != 0) ? temp * temp * x: temp*temp;
    }
}
