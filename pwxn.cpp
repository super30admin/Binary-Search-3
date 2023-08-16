class Solution {
public:

    double myPow(double x, int n) {

        if(n<0){
            n*=1;
            x=1/x;
        }

        double rs = 1.0;

        while(n!=0){
            if(n%2!=0){
                rs=rs*x;
            }
            x*=x;
            n=n/2;
        }

        return rs;



        
        

        
        
        
        
    }

    
    
};