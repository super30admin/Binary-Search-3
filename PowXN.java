/*
    L.C 50. Pow(x, n)

    Approach: recursion

    Working:

        myPow(double x, int n):

            //base
            when n is ZERO   // anything power zero is always 1
                return 1.0

            declare result
            //recurse
            result = myPow(x, n/2 -> reducing by half)

            when n is EVEN
                return result * result  // n = 4 2^2 * 2^2 = 2^4
            else // odd

                when n is POSITIVE
                    return result * result * x; // n=3 => n/2=1 => 2^1 * 2^1 * 2 -> for n is odd
                else // NEGATIVE
                    return result * result * 1/x


    Time Complexity: O(log n) //since at each sep n is reduced by half
    Space Complexity: O(log n) // recursive stack space
 */


class PowXN {
    public double myPow(double x, int n) {

        if(n == 0) {
            return 1.0;
        }

        double result = myPow(x,n/2);
        if(n%2 == 0) {
            return result * result;
        }
        else {
            if(n>0) {
                return result * x * result;
            }
            else {
                return result * 1/x * result;
            }
        }
    }
}
