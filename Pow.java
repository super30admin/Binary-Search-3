// 50. Pow(x, n) - https://leetcode.com/problems/powx-n/
// Time complexity - O(NlogN)
// Space complexity - O(1)
// Any problem? No
// Submitted on leetcode? Yes

class Solution {
    public double myPow(double x, int n) {
        // base
        if(n == 0) return 1;
        // logic
        double result = myPow(x, n/2);
        if(n%2 == 0) return result * result; // even
        else if(n > 0) return result * result * x; // greater than 0 and odd
        else return result * result * 1/x;
        
    }
}