//Time complexity: O(log N)
//Space Complexity: O(1)

class Solution {
    public double myPow(double x, int n) {

        if(x==1)
            return 1;
        if(x==-1)
            if(n%2 == 0)
                return 1;
            else
                return -1;
        else if (n==Integer.MIN_VALUE)
            return 0;
        else if(n<0){
            n*=-1;
            x = 1/x;
        }
        else if (n==0)
            return 1;

        double pow = x;

        double res =1;

        while(n>0){
            if((n & 1) == 1){
                res*=pow;
            }

            n>>>=1;
            pow *= pow;
        }

        return res;
    }
}