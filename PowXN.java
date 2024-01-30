//T.C O(log n) as we are diving i/p by half everytime
//S.C O(1)

/*
Use recursion
 */
class PowXN {
    public double myPow(double x, int n) {
        //base - last rec call
        if(n == 0) return 1.0;
        double result = myPow(x, n/2);

        if(n<0){
            n = n* -1;
            x = 1/x;
        }
        if(n%2 == 0)
            result = result * result;
        else
            result = result * result * x;

        return result;
    }
}