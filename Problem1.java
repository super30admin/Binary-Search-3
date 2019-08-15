// Time Complexity :O(N)  
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No


public double myPow(double x, int n) {
        if(x == 0)  return 0;
        if(n == 0)  return 1;
        double y=x;
        if(n>=0){
            while(n>1){
                y*=x;
                n--;
            }
        }
        else{
            y = 1/y;
            while(n<-1){
                y = y*(1/x);
                n++;
            }
        }
        return y;
    }
