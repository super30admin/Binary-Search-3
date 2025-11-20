/**
 * 
 */

/**
 * @author Aditya Sinha
 * If exponent is -ve, invert x and make n positive
 * loop while n is not zero, multiply result when n is odd
 * at each step squares x and halves n to reduce work logarithmically
 * Time Complexity - O(log n)
 * Space Complexity - O(1)
 *
 */
public class Pow {

	public double myPow(double x, int n) {
        double result = 1.0;

        if (n < 0) {
            x = 1 / x;
            n = n * -1;
        }

        while (n != 0) {

            if (n % 2 != 0) {
                result = result * x;
            }

            x = x * x;
            n = n / 2;
        }

        return result;
    
    }
}
