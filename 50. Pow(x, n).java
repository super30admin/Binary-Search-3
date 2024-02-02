class Solution {
    public double myPow(double x, int n) {
        boolean isNegative = n < 0;
        boolean isMaxNeg = false;
        if(n == Integer.MIN_VALUE){
            isMaxNeg = true;
            n++;
        }
        n = Math.abs(n);
        if(n == 0) return 1;
        if(n == 1) return isNegative ? 1/x : x;
        int div2 = (int) n/2;
        boolean rem = n%2 == 1;
        double subRes = myPow(x, div2);
        double interim = subRes * subRes * (rem ? x : 1);
        if(isMaxNeg) interim *= x;
        if (isNegative) interim = 1/interim;
        return interim;                
    }
}
