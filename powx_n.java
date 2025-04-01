//TC: O(logn) ->because power is reduced by half every time
//SC: O(logn)

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n==0) return 1.00;
        
        //logic
        double result;
        result = myPow(x,n/2);
        if(n%2==0){   //if n is even
            return result * result;
        }else{
            if(n<0){   //is n is odd and power is negative
                return result*result* 1/x;
            }else{
                return result*result *x;    //n is odd and power is positive
            }
        }
        
    }
}
