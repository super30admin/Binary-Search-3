// TC: O(log n)
// SC:  O(1)

public class Power {
    public double myPow(double x, int n) {
        double temp = 1.0;
        if (n < 0) {
            x = 1/x;
            n *= -1;
        }
        while (n != 0) {
            if (n % 2 != 0) {
                temp = temp* x;
            } 
            
            x = x*x;
            n = n / 2;
        }
        return temp;
    }
}