package BinarySearch3;

public class quesion87_Powxn {
    /* Created by palak on 7/7/2021 */
    /*
        TC: O(logn)
        SC: O(1)
    */
    public static double myPow(double x, int n) {
        //Base
        if(n == 0) return 1;
        //Logic
        double result = myPow(x, n/2);
        if(n % 2 == 0) return result * result;
        else {
            if(n > 0) return result * result * x;
            else return result * result * 1/x;
        }
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }
}
