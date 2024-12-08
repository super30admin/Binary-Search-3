//55. Pow(x,n) - https://leetcode.com/problems/powx-n/description/
//Time Complexity: O(log (n))
//Space Complexity: Stack Space (log(n))

//Recursion
class Solution {
    public double myPow(double x, int n) {
        //base case
        if(n == 0){
            return 1;
        }
        //logic
        double result = myPow(x, n/2);
        //even scenario
        if(n%2 == 0){
            return result * result;
        } else {
            //odd scenario
            if(n < 0){
                return result * result * 1/x;
            } else {
                return result * result * x;
            }
        }

    }
}

//Optimal
//Time Complexity: O(log(n))
//Space Complexity: O(1)
class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        if(n < 0){
            x = 1/x;
        }
        while(n != 0){
            if(n % 2 != 0){
                result = result * x;
            }
            x = x * x;
            n = n/2;
        }
        return result;
    }
}