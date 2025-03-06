// Pow(x,n) (https://leetcode.com/problems/powx-n/)

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, if n is negative make x as i/x and n as positive. Iterate until n is not equals to 0. Everytime if n is odd multiply re with
 * x and make x as x*x and n as n/2 in all cases. Finally return re.
 */
class Solution {
    public double myPow(double x, int n) {
        double re = 1.0;
        if(n < 0){
            x = 1/x;
            n = n * -1;
        }
        while(n!=0){
            if(n%2!=0){
                re = re * x;
            }
            x = x * x;
            n = n/2;
        }
        return re;
    }
}