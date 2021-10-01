/*


Please explain why it is O( Log n)

I am not good with time  complexities



*/

class Solution {
    public double myPow(double x, int n) {
        
        //base
        
        if (n == 0){
            return 1.00;
        }
        //logic
        double result = myPow(x, n/2);
        if(n%2 == 0){
            return result*result;
        }
        if(n>0){
            return result*result* x;    
        }
        return result*result* (1/x);
              
    }
}

