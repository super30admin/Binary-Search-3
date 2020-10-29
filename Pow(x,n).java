/*
TC : O(log n)
SC : O(log n)
Difficulty: had base case as n==1 initially
Did it run on Leetcode: yes
Approach:
recursively compute x^n/2
multiply halves
if n is odd multiply by additional x 
*/

class Solution {
    private double computePow(double x, int n){
        if(n==0){
            return 1;
        }

        double half = computePow(x, n/2);
        
        if(n%2==0){
            return half*half;
        }
        else{
            return half*half*x;
        }
    }
    
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(x==1) return 1;
        
        double result;
        
        result = computePow(x, Math.abs(n));
        
        if(n<0){
            result = 1/result;
        } 
        
        return result;
    }
}
/*
Bruteforce
TC : O(n)
SC : O(1)
Difficulty: handling edge cases of 1, -1, num^Integer.MIN_VALUE
Did it run on Leetcode: yes
Approach:
take result = 1, multiply x n times
*/
class Solution {
    public double myPow(double x, int n) {
        if(n==0 || x==1) return 1;
        if(x==-1){
            if(n%2==0) return 1; 
            else return -1;
        }
        
        if(n==Integer.MIN_VALUE) return 0;
        
        double result = 1;
        int pow = Math.abs(n);
        
        while(pow>0){
            result *= x;
            pow--;
        }
        
        if(n<0){
            result = 1/result;
        }
        
        return result;
    }
}