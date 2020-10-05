// TC: O(logN) since we are traversing only logN times(even and odd)
// SC: O(logN) for recursion stack

// If n is 0, we know that the anything to power 0 is 1.
// If n is less than 0, we need to update our x to 1/x and n as positive
// We recurse and multiply x with itself is n is even, or if x is odd, we multiply x with the new function.

public class powerXN {

	public double myPow(int n, double x) {
		
		if( n == 0)
			return 1;
		
		if( n < 0 ) {
			x = 1/x;
			n = -n;
		}
		
		return (n%2==0)? myPow(n/2, x*x): x*myPow(n/2, x*x);
	}
	
	public static void main(String[] args) {
		
		powerXN pow = new powerXN();
		System.out.println(pow.myPow(10, 2.000));
	}
}
