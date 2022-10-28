class Solution {
    // T.C : O(log n)
    // S.C : O(1)
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        double myhalf = myPow(x, n/2);
        
        if (n % 2 == 0) 
            return myhalf * myhalf;
        else {
            if (n > 0)
                return x * myhalf * myhalf;
            else
                return 1/x * myhalf * myhalf;
        }
    }
}