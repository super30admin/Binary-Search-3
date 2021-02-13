// Time Complexity :O(n)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode :NO-(TLE)
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Below is the brute force solution.

class Solution {
    public double myPow(double x, int n) {
        double result=1;
        if(n<0){
            for(int i=1;i<=(-1*n);i++){
                result=result*(1/x);
            }  
        }
        for(int i=1;i<=n;i++){
            result=result*x;
        }
        return result;
    }
}

//the complexity os O(logn)
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        
        double temp=myPow(x,n/2);
        //System.out.println(temp);
        if(n%2==0){
            return temp*temp;
        }else{
            if(n<0){
               return temp*temp*(1/x); 
            }else{
               return temp*temp*x;
            }
        }
    }
}