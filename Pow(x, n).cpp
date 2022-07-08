//Time Complexity- O(logn)
//Space Complexity- O(1)

class Solution {
public:
    double myPow(double x, int n) {
        
        return pow(x,n);
    }
    
    double pow(double x,int n){
        double temp;
        if(n==0){
           return 1; 
        } 
        temp=pow(x,n/2);
        if (n%2==0){
            return temp*temp;
        }
        else{
            if(n>0){
                return x*temp*temp;
            }
            else{
                return (temp*temp)/x;
            }
        }
    }
};