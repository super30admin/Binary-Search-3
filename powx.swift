

// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

        func myPow(_ x: Double, _ n: Int) -> Double {
        var ans : Double
        var n = n
        if n == 0 {
            return 1
        } 
        var temp = myPow(x,n/2)
            
        if n % 2 == 0 {
            return temp * temp
        } else if n < 0 {
            return temp * temp * 1/x
         }
         else {
            return temp * temp * x
        }
        
    }
