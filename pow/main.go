/*
    Why is this even a question.... I will never ever implement my own math.Pow... 
    Interviews are getting out of control these days but this is the game we have to play...
    so it is what it is.... sigh
    
    approach: brute force 
    - loop n times and multiply x...
    - if n < 0 , then x = 1/x and n = -n
    - for loop 0 to n(exlcuding n and multiply x each time to a result var)
    - return result
    time: o(n) - we loop n times
    space: o(1)
    - Outcome: TLE
    
    approach: logN recursive
    - half the exponent in each recursive call
    - once we reach the leaf of our recursion tree ( the base case when exponent will be 0)
        - then return 1.00
    - once we go back from leaf to a parent call
    - we will check if n is an event nu
        - if yes, return result * result * 1/x
    - otherwise 
    
    
*/
// brute force
// func myPow(x float64, n int) float64 {
//     if n < 0 {
//         x = 1/x
//         n *= -1
//     }
//     result := 1.0
//     for i := 0; i < n; i++ {
//         result *= x
//     }
//     return result
// }

func myPow(x float64, n int) float64 {
    if n < 0 {
        x = 1/x
        n = -n
    }
    var helper func(base float64, exp int) float64
    helper = func(base float64, exp int) float64 {
        // base
        if exp == 0 {return 1.00}
        // logic
        result := helper(base, exp/2)
        if exp % 2 == 0 {
            return result * result
        } else {
            return result * result * base
        }
    }
    
    
    return helper(x, n)
}
