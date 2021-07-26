
/*
        TC: O(logn)
        SC: O(1)
 */


class Powxn {
    public double myPow(double x, int n) {
    //base
    if(n== 0) return 1;
    //logic
    double result = myPow(x,n/2);
    if(n % 2 == 0)  return result * result;  
    else{
        if(n > 0) return result * result * x;
        else
            return result * result * 1/x;
    }    
        
    }
}