// Time Complexity:    O(log(n))
// Space Complexity:   O(log(n))
// where n is power
// This code ran successfully on Leetcode

// ****************************** Iterative Approach ******************************
public class Pow {
    public double myPow(double x, int n) {
        double X = x;
        long N = n;
        double ans = 1;

        if(N < 0) {                                   // for negative power, we are inverting x & making power positive
            X = 1/X;
            N = -N;
        }

        while(N > 0) {
            System.out.println("N: "+N);
            System.out.println("X: "+X);
            if(N%2 != 0) {                            // odd power
                ans *= X;
            }
            X *= X;
            N /= 2;
            System.out.println("ans: "+ans+"\n");
        }

        return ans;
    }
}




//// ****************************** Another Approach ******************************
//public class Pow {
//    public double myPow(double x, int n) {
//
//        // BASE
//        if(n == 0)
//            return 1;
//
//        int nBy2 = n/2;
//
//        if(n < 0) {                                   // for negative power, we are inverting x & making power positive
//            x = 1/x;
//            nBy2 = -nBy2;
//        }
//
//        // RECURSION
//        double res = myPow(x, nBy2);
//
//        if(n%2 != 0)                                 // odd power
//            return res*res*x;
//        return res*res;                              // even power
//    }
//}



//// ****************************** Another Approach ******************************
//public class Pow {
//    public double myPow(double x, int n) {
//        return myPowRec(x, n);
//    }
//    double myPowRec(double x, long n) {
//        // BASE
//        if(n == 0)
//            return 1;
//
//        // RECURSION
//        double res = myPowRec(x, n/2);
//
//        if(n < 0)                                    // for negative power, we are inverting x & making power positive
//            x = 1/x;
//
//        if(n%2 != 0)                                 // odd power
//            return res*res*x;
//        return res*res;                              // even power
//    }
//}




//// ****************************** Another Approach ******************************
//public class Pow {
//    public double myPow(double x, int n) {
//        long N = n;                                  // if n = -2^31 then if we convert it to +ve it will throw value out of bounds, thus we take it long in this implementation
//        if(N < 0) {                                  // for negative power, we are inverting x & making power positive
//            x = 1/x;
//            N = -N;
//        }
//        return myPowRec(x, N);
//    }
//    double myPowRec(double x, long N) {
//        // BASE
//        if(N == 0)
//            return 1;
//
//        // RECURSION
//        double res = myPowRec(x, N/2);
//        if(N%2 != 0)                                 // odd power
//            return res*res*x;
//        return res*res;                              // even power
//    }
//}

//// ****************************** Another Approach ******************************
//// Do not need to bother about exact value, we get amount correctly and power is not correct in below approach
//public class Power {
//    public double myPow(double x, int n) {
//        if(n < 0)                                    // for negative power, we are inverting x & making power positive
//            x = 1/x;
//
//        return myPowRec(x, n);
//    }
//    double myPowRec(double x, long n) {
//        // BASE
//        if(n == 0)
//            return 1;
//
//        // RECURSION
//        double res = myPowRec(x, n/2);
//        if(n%2 != 0)                                 // odd power
//            return res*res*x;
//        return res*res;                              // even power
//    }
//}
