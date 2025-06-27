class Solution {
    //Iterative Approach
    public double myPow(double x, int n) {
        double output = 1.0;
        if(n<0){
            x = 1/x;
        }
        while(n!=0){
            if(n%2!=0){
                output = output*x;
            }
            x = x*x;
            n = n/2;

        }
        return output;
    }
       
    



    //Recursive Approach
    // public double myPow(double x, int n) {
    //     //base case
    //     if(n==0){
    //         return 1;
    //     }
    //     //logic
    //     double output = myPow(x , n/2);
    //     if(n<0){x=1/x;}
    //     if(n%2!=0){
    //         return output*output*x;
    //     }
    //     else{
    //         return output*output;
    //     }
        
        
    // }
}