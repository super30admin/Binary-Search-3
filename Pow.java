/*
TC: O(logn) each n is reduced by half
SC: O(logn) recursion stack.

1. To compute X ^ 2n, by having X^n, we need not multiple X again n times. We can do (X^n)^2. This can be done in one computation. 
2. We use recursion to store intermediate values.
3. Reduce the n by half in every call. 

*/

public class Pow{

    public double myPow(double x, int n){

        if(n == 0) return 1.0;

        if(n < 0){
            if(n == Integer.MIN_VALUE){
                n += 2;
            }
            x = 1 / x;
            n = -n;
        }

        if(n % 2 == 0){
            return myPow(x * x, n / 2);
        }else{
            return myPow(x * x, n / 2) * x;
        }
    }

    public static void main(String[] args){
        Pow pow = new Pow();
        System.out.println(pow.myPow(2, -4));
    }
}