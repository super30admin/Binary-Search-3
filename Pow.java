// TC: O(log n)
// SC: O(1)

public class Pow {

  static double myPow(double x, int n) {
    // base
    if (n == 0)
      return 1.0;
    // logic
    double re = myPow(x, n / 2);
    if (n < 0) {
      x = 1 / x;
    }
    if (n % 2 == 0) {
      return re * re;
    } else {
      return re * re * x;
    }
  }

  public static void main(String[] args) {
    double x = 2.00000;
    int n = 10;

    System.out.println(myPow(x, n));
  }
}