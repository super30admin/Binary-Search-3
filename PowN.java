// Time Complexity: O(logn)
// Space Complexity: O(logn)


class PowN {
    public double myPowRecursion(double x, int n) {
        if(n == 0){
            return 1.0;
        }

        double re = myPowRecursion(x, n/2);

        if(n % 2 != 0){
            if(n > 0){
                return re * re * x;
            }else{
                return re * re * 1/x;
            }
        }else{
            return re*re;
        }
    }

    // Space Complexity: O(1)s
    public double myPow(double x, int n) {

        long nn = n;
        if(n < 0){
            nn *= -1;
            x = 1/x;
        }
        double re = 1.0;
        while(nn > 0){
            if(nn % 2 != 0){
                re = re * x;
            }
            x = x*x;
            nn = nn/2;
        }
        return re;
    }
}


