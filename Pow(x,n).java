// Time Complexity: O(log N)
// Space Complexity: O(log N)
// Run on leetcode: yes
// Issues faced: None

class Solution {  
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        double ans = myPow(x, n/2);
        if(Math.abs(n)%2==0)
            return ans*ans;
        else if(n > 0 && n%2!=0)
            return x*ans*ans;
        // else if(n < 0 && Math.abs(n)%2 != 0)
        else
            return (1/x)*ans*ans;
    }
    
}
