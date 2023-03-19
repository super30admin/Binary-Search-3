//Time Complexity: O(log(n))
//Space Complexity: O(log(n)), rescursive stack only

class Solution {
    public double myPow(double x, int n) {

        //base
        if(n==0) return 1.000;                      //check if n==0, then return 1

        //logic
        double result = myPow(x, n/2);              //otherwise call the recusrive function on n/2

        if(n%2 ==0){                                //check if n%2 ==0, then return result*result

            return result * result;
        }
        else{                                   //if not, then check if n is negative or not,

            if(n<0){

                return result * result * (1/x);             //if it is negative, then return result*result*1/x
            }
            else{

                return result * result * x;                 //otherwise, return result * result * x
            }
        }
    }
}

public class PowLeetCode50 {
}
