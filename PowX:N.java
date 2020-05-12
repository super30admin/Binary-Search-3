class Solution {
    public double myPow(double x, int n) {
        
        if (n == 0){
            return 1;
        }
        
        double my_Val = myPow(x,n/2);
        
        if (n % 2 == 0){
            return my_Val * my_Val;
        } else {
            if (n > 0){
                return my_Val * my_Val * x;
            } else {
                return my_Val * my_Val * (1/x);
            }
        }
        
    }
}