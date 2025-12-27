
class SoluPowofXofNtion {
    public double myPow(double x, int n) {
        // iterative way
        double res = 1.0;
        if(n < 0)
        {
            x = 1/x; // make it 1/x, and we can do x*x for any value of x
        }
        while(0 != n)
        {
            if(n % 2 != 0) // for odd values of n, we multiple x extra as compared to even values of n
            {
                res = res * x; 
            }
            x = x * x;
            n = n/2;
        }
        return res;
    }
}
