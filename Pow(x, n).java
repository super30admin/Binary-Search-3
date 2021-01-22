/*
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base
        if n == 0:
            return 1
        
        # logic
        ans = self.myPow(x, int(float(n)/2))                # using n//2 fails for negative nos as -1//2 gives -1 instead of 0
        
        if n % 2 == 0:
            return ans*ans
        
        else:
            if n < 0:
                return ans * ans * (1/x)
            return ans * ans * x
*/

// Time Complexity : O(logn)
// Space Complexity : O(logn)

// Your code here along with comments explaining your approach: I halved the power everytime and calculated

class Solution {
    public double myPow(double x, int n) {
        // base
        if (n == 0)
            return 1;
        
        // logic
        double ans = myPow(x, n/2);
        
        if (n % 2 == 0){
            return ans * ans;
        }
        else{
            if (n < 0)
                return ans * ans * 1/x;
            return ans * ans * x;
        }
        
    }
}