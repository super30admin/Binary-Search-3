 //Time Complexity:O(log n)
//Space Complexity:O(log n) -> recursive stack
//Recursive approach, half n, 
class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;

        double result = myPow(x,n/2);

        if(n<0)
            x = 1/x;

        result = result * result;

        if(n%2!=0)
            result = result * x;
        
        return result;
    }
}

///Time Complexity:O(log n)
//Space Complexity:O(1)
//Iterative approach 
class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;

        double result = 1.0;
        if(n<0){
            //n= n*-1;
            x = 1/x;
        }
        while(n!=0){   //to handle -2^31 scenario , use n!=0
            if(n%2!=0)
            result = result * x;

            n = n/2;
            x= x*x;
        }
        return result;
    }
}