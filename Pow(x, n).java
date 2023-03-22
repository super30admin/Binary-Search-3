class Solution {
	//O(Time): log n; since only the log n number of calls are conducted
	//O(Space): log n
    public double myPow(double x, int n) {
        //This is a good question for practicing recursion.
        //Every time we divide the power by 2, by doing this the power needs to be calculated only log n times.
        //go all the way down till quotient = 0
        
        //Handle the negative case.
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        
        //No need to send remainder, you can remove it later.
        return  pow_helper(x, N, 1234);
         
    }
    
    public double pow_helper(double base, long q, long rem){
        
        if(q == 0){
            
            return 1.0;
            
        }
        long remainder = q % 2;
        q = q/2;
        
        double to_be_squared = pow_helper(base, q, remainder);
        
        if(remainder == 0){
                return to_be_squared * to_be_squared;
            }
            
            
        
        return to_be_squared * to_be_squared * base;
        
    }
}