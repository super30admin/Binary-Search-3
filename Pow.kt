// In this problem, we need to calculate x raised to the power n. Instead of multiplying x by itself n times, use exponentiation by squaring to reduce the exponent by half each step and square the base.
// Time complexity: O(log n) because we are halving the exponent at each step.
// Space complexity: O(1) 

class Solution {
    fun myPow(x: Double, n: Int): Double {
        var result = 1.0
        var newX = x
        var newN = n
        if (newN < 0){
            newX = 1/newX
            newN = newN* -1
        }

        while(newN != 0) {
            if(newN % 2 != 0) {
                result = result * newX
            }
            newX = newX*newX
            newN = newN/2
        }

        return result
    }
}