/*
TC -> O(N)
SC-> O(1)
*/



class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = myPow(x, n / 2);
        if (n % 2 == 0) {
            //Handling the even numbers
            return y * y;
        } else {
            //Handling the odd numbers
            if (n % 2 == 1) {
                return y * y * x;
            } else {
                //Handling the -ve numbers
                return y * y * 1 / x;
            }
        }
    }
}