package s30.binarySearch.b3;


//Algo: recursive => We can divide higher power into 2 halves then call them recusrsively
// TC: O(logn);
//SC: O(logn) for recursive calls

//Algo: Iterative => using binary of power.
// TC: O(logn)
// SC : O(1)
public class Power {


    public double myPow(double x, int n) {

        double res =1;
        long tN = n;
        if( tN < 0){
            x = 1/x;
            tN = -1 * tN;
        }

        while(tN > 0){
            if((tN  & 1) != 0){
                res *= x;
            }

            x *= x;
            tN = tN >> 1;
        }

        return res;
    }
    public double myPowRec(double x, int n) {

        long tempN = n;
        //should run only once;
        if(n < 0){
            x = 1/x;
            tempN = -1 * tempN;
        }

       //base
        if(n ==0) return 1;

        double curr =  (n & 1) !=0 ? x: 1;

        double halfPower = myPow(x, (int)(tempN/2));

        return curr * halfPower * halfPower;
    }
    public static void main(String[] args) {
      double t1=  Double.MIN_VALUE;
        System.out.println(Math.max(t1, -1));
    }
}
