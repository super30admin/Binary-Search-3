// Time Complexity: O(logn)
// Space Complexity: O(1)
public class Pow {
    public double myPow(double x, int n) {
        //base
        if(n == 0) return 1.000;
        //logic
        double result = myPow(x, n/2);
        if(n%2 == 0){
            result = result * result;
        }
        else{
            if(n<0){
                result = result * result * (1/x);
            }
            else result = result * result * x;
        }
        return result;
    }
}
