class Pow(x,n) {

    // Time Complexity: O(log n)
    // Space Complexity: O(log n)   (space by recursion stack)

    public double myPow(double x, int n) {
        // If n = 0 --> return 1 (anything raised to zero is one)
        if(n == 0)
            return 1;
        double temp = myPow(x, n/2);
        // If n is even then -> multiply the returned value twice
        if(n % 2 == 0){
            return temp * temp;
        }
        // else multiply the returned value twice as well as x (both +ve and -ve cases)
        else{
            if(n < 0){
                return temp * temp * (1/x);
            }else{
                return temp * temp * x;
            }
        }
    }
}