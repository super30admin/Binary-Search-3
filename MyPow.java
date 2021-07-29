// Time Complexity : O(log n)
// Space Complexity : O(1)

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0)
            return 1;
        //logic
        double prod;
        prod = myPow(x , n / 2);
        if(n % 2 == 0)
            return prod * prod;
        else{
            if(n > 0)
                return prod * prod * x;
            else
                return prod * prod * 1 / x;
        }
    }
}