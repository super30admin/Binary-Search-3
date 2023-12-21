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