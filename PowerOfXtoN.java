public class PowerOfXtoN {
    public static double myPowIteration(double x, int n) { //O(logn) T.C, O(1) S.C
        double result = 1.0;
        if(n<0) { //if negative power
            x=1/x; //for ex, 2^-1 = 1/2.
        }
        while(n!=0) {
            if(n%2 != 0) result *= x; //whenever n becomes odd, multiple existing result with current x
            x = x*x; //keep on multiplying x with itself
            n = n/2; //keep on halving the n until it becomes 0
        }
        return result;
    }

    public static double myPowRecursion(double x, int n) { //O(logn) T.C, O(logn) S.C recursive stack
        //base
        if(n==0) return 1; //Ex, 2^0 = 1

        //logic
        double result = myPowRecursion(x, n/2); //recurse by halving n until it becomes 0
        if(n%2==0) { //if n is even, both negative and positive are handled here as (- * - = +)
            return result*result; //multiply by itself
        } else { //n is odd
            if(n < 0) { //if n is negative
                return result*result*(1/x); //multiply result by itself and also with 1/x
            } else { //n is positive
                return result*result*x; //multiply result by itself and also with x one time
            }
        }
    }

    public static void main(String[] args) {
        double x1 = 15.0;
        int n1 = 5;
        System.out.println(x1 + " raised to the power of " + n1 + " using iteration is: " +
                myPowIteration(x1, n1));

        double x2 = 78.0;
        int n2 = 3;
        System.out.println(x2 + " raised to the power of " + n2 + " using recursion is: " +
                myPowRecursion(x2, n2));
    }
}