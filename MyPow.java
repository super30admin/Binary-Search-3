// TC: O(n) since we are looping from n till 0
// SC: O(n) for the recursion stack

// recurse over the x and n values, if n is even, we square x value and reduce the n value by half, or if the n is odd, we multiply the x with the function and recurse over
// square of x and n/2, one we reach n as 0, we should return 1 considering it as base case. So every time we return, we multiply the corresponding values of x and keep returning
// Also, the n can be - negative, So we need will make n as positive and x as 1/x because we know that powering of pow(2, -3) is pow(1/2, 3)

public class MyPow {

	public double myPow(double x, int n) {
		
		if(n == 0)
			return 1;
		
		if(n < 0 || n > Integer.MIN_VALUE) {
			n = -n;
			x = 1/x;
		}
		return (n%2==0)? myPow( x*x, n/2) : x*myPow(x*x, n/2);
	}
	
	public static void main(String[] args) {
		
		MyPow mp = new MyPow();
		System.out.println(mp.myPow(2, 10));
	}
}
