// Time Complexity : O(logn)
// Space Complexity : O(logn) in recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if x is 0 return 0
if n < 0  set x = 1/x
return recursive function with x, abs(n)

in recursive function
if n is 0 return 1
if n is even set temp as recursive(x, n/2)
return temp*temp
else set temp as recursive(x, (n-1)/2)
return temp*temp*x
*/
package main

import "fmt"

func myPow(x float64, n int) float64 {
	if x == 0 {
		return 0.0
	}
	if n < 0 {
		x = 1/x
	}
	return h(x, abs(n))
}

func abs(n int) int {
	if n < 0 {
		return -1*n
	}
	return n
}

func h(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	if n % 2 == 0 {
		temp := h(x, n/2)
		return temp * temp
	} else {
		temp := h(x, (n-1)/2)
		return temp * temp * x
	}
}

func MainPow() {
	fmt.Println(myPow(2.0, 10))
}
