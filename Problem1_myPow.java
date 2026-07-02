class Solution {
    public double myPow(double x, int n) {
        long power = n;//use long for Integer.MIN_VALUE CASE

        if(power < 0){
            x = 1 / x;
            power = -power;
        }
        double result = 1.0;

        while(power > 0){
            //if power is odd multiply current x
            if(power % 2 == 1){
                result *= x;
            }
            //square x
             x *= x;

             //divide power by 2
             power /= 2;
        }
        return result;
    }
}