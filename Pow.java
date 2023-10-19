//TC will be O(n)
// SC will be O(1)
class Pow {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        double result = myPow(x, n/2);
        if(n % 2 == 0){
            return result * result;
        }
        else{
            if(n > 0){
                return result * result * x;
            }
            else{
                return result * result * 1 / x;
            }
        }
    }

    public static void main(String[] args){
        double x = 2.00000;
        int n = 10;
        Pow obj = new Pow();
        System.out.println(obj.myPow(x,n));
    }
}