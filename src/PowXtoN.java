class PowXtoN {
    public double myPow(double x, int n) {
        if(n<0) {
            x = 1/x;
        }
        double result = helper(x,n);
        return result;
    }

    private double helper(double x, int n) {
        // base case
        if(n==0) return 1;
        // logic
        double result = helper(x,n/2);
        if(n%2 == 0) {
            return result*result;
        } else{
            return result*result*x;
        }
    }
}