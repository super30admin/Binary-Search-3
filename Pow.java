// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Pow {
    public double myPow(double x, int n) {

        if(n==0) return 1.000;

        //logic
        double result = myPow(x,n/2);
        if(n%2==0){
            return result*result;
        }
        else{
            if(n<0){
                return result*result*(1/x);
            }
            else{
                return result*result*x;
            }
        }
    }

    public static void main(String [] args){
        Pow p = new Pow();
        System.out.println(p.myPow(2.00000, 10));
    }
}