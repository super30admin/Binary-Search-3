// Time Complexity - O(log(n))
// Space Complexity - O(log(n))
class Solution {
    public double myPow(double x, int n) {
        // base case
        if(n == 0){
            return 1.0;
        }
        // logic 
        double half = myPow(x, n/2);
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        if(n % 2 == 0){
            x = half * half;
        }else{
            x = x * half * half;
        }

        return x;
    }
}
