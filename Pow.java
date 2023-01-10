public class Pow {
    // TC - O(logn)
    //SC - O(logn)
/*
* Recursively call myPow and handle cases for odd numbers and even numbers.
* */

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x,n));
    }
    public static double myPow(double x, int n) {
        if(n==0) return 1.0;
        double ans = myPow(x,n/2);
        if(n%2==0) return ans*ans;
        else{
            if(n>0) return ans* ans*x;
            else return ans*ans/x;
        }
    }


}
