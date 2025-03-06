class Pow {
    public double myPow(double x, int n) {
        
        if(n==0)
        return 1.0;

        double re = myPow(x,n/2);
        if(n%2 !=0)
        {
            if(n>0)
            {
                return re *re *x;
            }
            else{
                return re *re *1 /x;
            }
        }
        {
            return re *re;
        }
    }
}

//Time Complexity (TC): O(log n), where n is the exponent.
//Space Complexity (SC): O(log n) due to the recursion stack.