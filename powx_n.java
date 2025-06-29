//Time Complexity: O(log n)
//Space Complexity: O(log n)

//Recursive Solution

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0)
            return 1.0;
        //logic
        double re = myPow(x, n/2);
        if(n < 0)
            x = 1/x;
        if(n%2 == 0){
            return re * re;
        } else{
            return re * re * x;
        }
    }
}

//Iterative Solution
//No extra space used
class Solution {
    public double myPow(double x, int n) {
        double re = 1.0;
        if(n < 0){
            x = 1/x;
        }
        while(n != 0){
            if(n%2 != 0){
                re = re * x;
            }
            x = x*x;
            n = n /2;

        }
        return re;
    }
}