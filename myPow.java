package week7.day2;
//TC - O(log n)
//SC - O(log n) for recursive stack
class Solution9 {
    double result;
    public double myPow(double x, int n) {
        //base
        if(n==0)
            return 1;
        result = myPow(x, n/2);
        //logic
        if(n%2 ==0){
            result = result*result;
        }
        else{
            if(n<0)
                result = result*result*1/x;
            else
                result = result*result*x;
        }
        return result;
    }
}
public class myPow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
