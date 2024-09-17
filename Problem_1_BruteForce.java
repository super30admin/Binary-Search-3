// Time complexity - O(n)
// Space complexity - O(1)

// Time limit exceeded
// Mulitple x, n times

class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        if(n>0){
            for(int i = 0;i <n; i++){
                result *= x;
            }
        }else{
            for(int i = 0; i < Math.abs(n);i++){
                result *= (1/x);
            }
        }
        return result;
    }
}
