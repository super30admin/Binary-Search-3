/*
Time Complexity: O(log(n)), here n is the given power
Space Complexity: O(log(n)), n is the given power and this space is space for recursion tree
Run on leetcode: yes
Any difficulties: no
Approach:
1. Divide and conquer approach, calculating result for half of the power and then using that to produce result for actual
power
2. Another case is of negative power, so when the power is negative I would be using 1/number as my number for calculations
(basic mathematics)
 */
public class Powxn {

    public static double powXN(double x, int n){
        if(n<0){
            x = 1/x;
        }
        return myPowerFunction(x, n);
    }

    public static double myPowerFunction(double x, int n){
        if(n == 0){
            return 1;
        }

        double result = myPowerFunction(x,n/2);

        if(n%2 == 0){
            return result*result;
        }
        return result*result*x;
    }

    public static void main(String[] args){
        double num = 2.0;
        System.out.println("Power calculation: "+powXN(num,10));
        System.out.println("Power calculation: "+powXN(2.00000,-2));
    }
}
