class Solution {
public:
    double myPow(double x, int n) {
        //iterative Approach
      Didn't try the iterative approach as it was failing some of the test cases if we don't change the data type of result from int to long.
        
    }
};

//Binary Solution
/*
   double myPow(double x, int n) {
    //Time - log (n) - because everytime it gets divided into halves.
    //Space - log (n)
    if(n==0)return 1;
    double result = pow(x, n/2);
    if(n%2==0){
        return result*result;
    }
    else{
        if(n>0){
            return result*result*(x);
        }
        else{
            return result*result*(1/x);
        }
    }
    }
*/


//earlier solution:
/*
double pow=1;
    if(n<0)x=1/x;
    long num = labs(n);
    while(num){
        if(num&1)
        pow *=x;
        x*=x;    
        num >>=1;
    }
    return pow;
    }
*/
