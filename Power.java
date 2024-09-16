//Time Complexity: O(logn)
//Space Complexity: O(logn)
//LeetCode: Yes

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        return helper(x, N);
    }
    
    private double helper(double x, long n){
        if(n == 0)return 1;
        if(n == 1)return x;
        double result = helper(x, n/2);
        if(n % 2 == 0)
            return result * result;
        else 
            return x * result * result;
    }
}
