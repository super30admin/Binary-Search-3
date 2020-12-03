// Time Complexity : O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set low to 0 and high to len(arr) - k as result lenght must be atleast k
while low<high
mid is middle
if x - arr[mid] > arr[mid+k] - x then increment low to mid+1 else decrement high to mid
return arr[low:low+k]
*/
package main

import "fmt"

func findClosestElements(arr []int, k int, x int) []int {
	low := 0
	high := len(arr) - k
	for low < high {
		mid := low + (high - low)/2
		if x - arr[mid] > arr[mid+k] - x {
			low = mid + 1
		} else {
			high = mid
		}
	}
	return arr[low:low+k]
}

func MainKClosestElement() {
	fmt.Println(findClosestElements([]int{1,2,3,4,5}, 4, 3)) //expected [1,2,3,4]
}
