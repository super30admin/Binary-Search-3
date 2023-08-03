public class PowXN {
    //Time Complexity: O(log N)
    //Space Complexity: O(1)
    public double myPow(double x, int n) {
        //needed to convert int n to long n for edge case where |integer.max| < |integer.min|
        return fastPow(x, n);
    }
    private double fastPow(double x, long n){

        if(n < 0){
            x = 1/x;
            n = n*(-1);
            return fastPow(x, n);
        }
        if(n == 0){
            return 1.0;
        }


        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
