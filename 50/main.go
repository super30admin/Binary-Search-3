package main

/*
if you try to do iterative approach where you are looping over the i and trying to find an answer the question will time out - obviosuly this is not an optimal solution

- now consider 2^4 is basically 2^2 * 2^2 - so basically we have reduced the number of computations we are doing in one function
- this is what we are going to do to find an optimal solution

*/
//tc : O(logn)
//space : O(logn) - recursive stack
func myPow(x float64, n int) float64 {
	if n == 0 {
		return 1.0
	} // anything raised to the power of 0 is 1
	result := myPow(x, n/2)
	// odd or even
	if n%2 == 0 {
		// even
		return result * result
	} else {
		// odd
		if n > 0 {
			return result * result * x
		}
		return result * result * (1 / x)
	}
}

// // is an iterative solution - need a better solution
// func myPow(x float64, n int) float64 {
//     if x == 0.0 { return 0.0 }
//     result := 1.0
//     negative := false
//     if n < 0 {
//         n = n * -1
//         negative = true
//     }
//     for i:=1;i<=n;i++{
//         result = result * x
//     }
//     if negative {
//         return 1/result
//     }
//     return result
// }
