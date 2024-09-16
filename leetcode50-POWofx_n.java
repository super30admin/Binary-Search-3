//Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

/* B_F:
	Take a double variable called answer
	
	take a for loop that runs from 1 till n , and keep on mutiplying answer* x if x>0  || answer*1/x if x < 0!!.
//base case are  == if x==0 return 0; if n == 0 return 1. 
time - O(n)
space O(1)	
	
*/ 


/*
OPTIMIZED Solution
	for any even power n, example 3^4 can be written as 3^2 * 3^2; while for odd let say 3^5 =  3^2 * 3^2 * 3
	
	so, we'll call a recursive function with power reduced to n/2 in each call, , that goes till we get x ^0 and this becomes the base case. 

we know x^0 = 1	, so we'll keep on coming back from the call stack and get the answer. 

TIME - everytime, we reducing search space/ power calculations to half, so log(n), and 
SPACE -  is same due to recursive stack. 

*/
class Solution {
    public double myPow(double x, int n) {
			//base case
			if(x==0) return 0;
			
			if(n==0) return 1;
			
			double answer = myPow(x, n/2);
			
			if(n%2 == 0)
			{
				return answer * answer;
				
			}
			else
			{
				if(n >0)
					return answer * answer * x;
				else
					return answer*answer* 1/x;
			}
		
	}
}
//same recursive approach different way - C# solution
public class Solution {
    public double MyPow(double x, int n) {
        if(x ==0) return 0;
        if(n ==0) return 1;
        
        double answer = MyPow(x, n/2);
        
        if(n <0)
            x = 1/x;
        
        if(n%2 ==0)
            return answer*answer;
        else
            return answer*answer*x;
            
    }
}

/*************************************************************************/
//Approach-2 Java
/*
Iterative
1. if n is odd, we collected result = result*x
else we just do n=n/2 and x = x*x

tc: O(logn)
sc: o(1)*/

//approach
//calculate in iterative fashion
//when power is odd, collect the result = result*temp
//else keep going., with even power, when reach to 0th power, collect result. 
//every step, n will increase in power of 2!

public class Solution {
    public double MyPow(double x, int n) { //2, -5
     
        double result =1.0;
        
       // if( n == 0) return 1;
        
        if(n<0)
          {
            //n = -n; // we dont need this as anyway we are just checking N is not zero!
            x = 1/x;
        }
        
        while(n != 0) //if we write while(n > 0) we may get integer overflow error; ex: 2.00000 //-2147483648

        {
            //check if odd power
            if(n%2 != 0)
                result *= x;
            
                n=n/2;
                x=x*x;
            
        }
        return result;
    }
}


