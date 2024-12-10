// Time complexity: O(logn) due to reducing the search in half
// spacce Complexity O(1) constant space

public class PowerxN {
    public double myPower( double x, int n){
        // handle negative power
        long N = Math.abs((long)n);

        if(n < 0){
            x = 1 / x;
            n  = -n;

        }

        double result = 1;
        double currentProduct = x;

        while( N > 0 ){
            if( N % 2 == 1) { // if N is odd multiply the current product

                result = result * currentProduct;
            }
                currentProduct *= currentProduct; // square the current product. skip the result part in case of even
                N = N/2; // halve the exponent

            }
        return result;
        }
        public static void main (String [] args){
            PowerxN pf = new PowerxN();
            System.out.println(pf.myPower(2, 10)); // 1024.0
            System.out.println(pf.myPower(2, -2)); // 0.25
            System.out.println(pf.myPower(2, 0));  // 1.0
            System.out.println(pf.myPower(2, 5));  // 32.0

    }
}
