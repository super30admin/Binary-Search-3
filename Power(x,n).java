//Problem 87 :  Pow(x, n)
//TC: O(log N)
//SC: O(1), or recursive stack will be (n/2) steps

/*
Steps : Bruteforce : TC:(O(n))- Multiple the number n times if n is +ve. If n is -ve divide the final result with 1.

        Optimized : TC:(O(log n))- Make the power half and recurse the function until n==0. At n==0 return 1.
                    Remenber following conditions
                    1) For each recursive call multiply rescursion result with itself which is temp*temp. If u r storing recursion result in temp variable.
                       a) If n is even just return the temp.
                       b) If n is odd perform the below steps and return temp
                             i) if n is -ve, in addition to step 1, multiply it with 1/x;
                             ii) if n is +ve, in addition to step 1, multiply it with x;

*/


class Solution87 {
    //TC: log(N), SC:O(1)
   public double myPow(double x, int n) {
       
       if(n==0) return 1;
       //just half the power
       double temp= myPow(x,n/2);
       if(n%2==0){//even
           return temp * temp;
       }else{
           if(n<0){//for negative number
           return temp * temp * 1/x;//because x^-1 is 1/x;
           }else{
            return temp * temp * x;   
           }
       }
       
   }
   
   /* Bruteforce
   //TC: O(n) | SC:O(1)
   public double myPow(double x, int n) {
       double res =1.0;
       for(int i=1;i<=Math.abs(n);i++){
           res = res * x;
       }
       
       if(n<0) return 1/res;
       
       return res;
   }*/
}