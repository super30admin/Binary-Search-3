//time complexity: O(logn) where n is the power
//space complexity; O(1)


class Solution {
    public double myPow(double x, int n) {
        // base
        if(n == 0) return 1;

        //logic
        double res = myPow(x, n/2);

        if(n % 2 == 0){
            return res * res;
        }
        else{
            if(n < 0){
                return 1/x * res * res;
            }
            else{
                return x * res * res;
            }

        }


    }
}
