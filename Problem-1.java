public class Problem-1 {
    public double myPow(double x, int n) {
        if(n < 0){
            x = 1/x;
        }

        return helper(x,n);
    }

    private double helper(double x, int n){
        //base
        if(n == 0) return 1;
        //logic
        double re = helper(x, n/2);
        if(n%2 == 0){
            //even
            return re * re;
        }else{
            return re * re * x;
        }
    }
}
