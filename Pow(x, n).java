// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Solution : Using Binary Search
class Solution {
    public double myPow(double x, int n) {
        //base case if power is 0, return ans as 1
        if(n == 0) return 1;
        //call the method again for n/2 
        //recursively
        double temp = myPow(x, n/2);
        //if n is even (pos) for power we multiply temp * temp    
        if(n%2 == 0) {
            return temp*temp;
        }
        //else if n is odd or negative
        //check for neg and odd(pos) condition
        else {
            if(n < 0) {
                //if n is neg, find temp*temp and multiply by 1/x
                return temp*temp*(1/x);
            }
            else {
                //if n is odd (pos) find temp*temp and multiply by x
                return temp*temp*x;
            }
        }
    }
}

//2^4 //even so returns 4*4 = 16
//temp = myPow(2, 2) //even so returns 2*2 = 4
//temp = myPow(2, 1) //odd so returns 1*1*2 = 2  (2^1 = 2)
//temp = myPow(2, 0) returns 1   ^