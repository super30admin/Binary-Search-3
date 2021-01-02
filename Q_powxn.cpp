
//## Problem1 
//Pow(x,n) (https://leetcode.com/problems/powx-n/)

//  Approach: Recursive , divide and conquer 
//for n , recursively call for n/2 and then mutliply by x or 1/x if n is odd and greater or lesser than 0


// # Time complexity: O(logn) 
// # Space complexity: O(logn) recursive stack call space



class Solution {
public:
    double myPow(double x, int n) {
        //base
        if(n==0){
            return 1;
        }
        
        
        //logic
        
        double temp = myPow( x, n/2);
        if(n%2==0){
            return temp* temp;
        }
        else{
            if(n<0){
                return temp*temp* 1/x;
            }
            return temp*temp*x;
        }
        
        
    }
};