//time complexity- O(log(n))

//space complexity- O(1)
public class PowerXtoN {
    static double myPow(double x, int n) {
        double result = 1.0;
        if(n < 0) {
            x = 1/x;
        }
        while( n != 0) {
            if(n % 2 != 0) {
                result = result * x;
            }
            x = x*x;
            n /= 2;
        }

        return result;
    }
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        System.out.println(x + " ^ " + n + " => " + myPow(x, n));
    }
}
