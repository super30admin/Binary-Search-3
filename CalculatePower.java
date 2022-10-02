// TC - O(log n)
// SC - O(1)

public class CalculatePower {
    static class Solution {
        public double myPow(double x, int n) {
            // base
            if (n==0) return 1.00;

            //logic
            double result = myPow(x,n/2);
            if(n% 2 == 0) {
                return result * result;
            }
            else{
                if (n>0) return result * result * x;
                else return result * result * (1/x) ;
            }
        }
    }

    static class Test{
        public static  void main(String[] args){
            Solution s = new Solution();
            System.out.println(s.myPow( 2.00000,10));
        }
    }
}
