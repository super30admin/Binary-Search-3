/*
Intuition: x ^n = x is multiplied n times.

We can club up even number of multiplications
#####################################################################
Solution Iterative
Time Complexity : O(log n) 
Space Complexity : O(1 )
#####################################################################
Solution Recursive
Time Complexity : O(log n) 
Space Complexity : O(log n )
#####################################################################
*/
//Recursive

class Solution {
public:
    double myPow(double x, int n) {
        if ( n == 0) return 1;
        double temp = myPow(x, n/2);
        
        if ( n %2 == 0){
            return temp * temp;
        }
        else{
            if ( n > 0){
                return temp * temp * x;
            }
            else{
                return temp * temp * 1/x;
            }
        }
        
    }
};

//Iterative
class Solution {
public:
    double myPow(double x, int n) {
        
        double answer = 1;
        long nCopy = n;
        if (n <0){
            nCopy = -1*nCopy;
        }
        
        while (nCopy >0){
        
            if (nCopy % 2 == 0){
                x = x * x;
                nCopy = nCopy /2 ;
            }
            else{
                answer = answer * x;
                nCopy = nCopy-1;
            
            }
        
        }
        if (n <0){
            answer = 1 / answer;
        }
        return answer;
        
        
    }
};