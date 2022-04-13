//Time Complexity : O(log n)
//Space Complexity : O(log n)
public class Pow_x_n {	
	public double myPow(double x, int n) {
		//base
        if(n==0) return 1;
        
        //logic   
        double res = myPow(x, n/2);  
        if(n%2==0)
            return res*res;
        else{
            if(n>0) return res*res*x;
            else return res*res*(1/x);           
        } 
    }
		
	// Driver code to test above
	public static void main (String[] args) {
		Pow_x_n ob = new Pow_x_n();	
		double x = 2.00000;
		int n = -2;//10;
		System.out.println("Calculated value of pow(x,n): "+ ob. myPow(x,n));
	}	
}
