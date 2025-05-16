//Time Complexity: O(logn)
// Space Complexity: O(1)

public class PowX {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }

        double pw = myPow(x, n/2);
        if(n%2 == 0){
            pw = pw*pw;
        }else{
            if(n > 0){
                pw = pw*pw*x;
            }else{
                pw = pw*pw*(1/x);
            }
        }
        return pw;
    }
}
