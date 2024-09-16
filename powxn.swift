//Iterative solution
//time complexity = logn
//space complexity = O(1)

class Solution {
    func myPow(_ x: Double, _ n: Int) -> Double {
        var pow: Double = 1
        var N = n
        if N == 0 {
            return 1
        }
        var cur: Double = x
        if N < 0 {
            cur = 1/x
            N = -n
        }
        var i = N
        while i > 1{
            if i%2 == 1 {
               pow = pow * cur
            }
            cur = cur * cur
            i=i/2
        }
        return pow * cur
    }
}