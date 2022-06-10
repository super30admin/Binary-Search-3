class Problem1 {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        
        double temp = myPow(x,n/2);
        double result = 1.0;
        
        if(n % 2 == 0){
            result = temp*temp;
        } 
        else{
            if(n < 0){
                result =  temp*temp/x;
            }
            else
                result = temp*temp*x;
        }
        return result;    
    }
}

// Time complexity O(logn)
// Space Complexity O(logn) for recursion stack
// Tested in leetcode