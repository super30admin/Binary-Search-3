//The approach here is to divide n by half and squaring x at each iteration.
//When we encounter an odd n value, then we multiply result with x at that iteration.
//We also cover negative n by converting into positive n and making x as 1/x;
//Time complexity: O(log n)
//Space Complexity: O(1)
class Solution {
    public double myPow(double x, int n) {
        double re = 1.0;
        if(n < 0){
            x = 1/x;
            n = n * -1;
        }
        while(n != 0){
            if(n%2 != 0){
                re = re * x;
            }
            x = x*x;
            n = n/2;
        }
        return re;
    }
}