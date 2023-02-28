package main

/*

Brute Force :
- take the difference of all elements
- sort them based on the difference and then return the initial 5 elements
- another solution can be to not sort it and then return the elements remaining in the heap (heap of size y which will be max heap). these need to be sorted and then returned. TC - nlogk

---
2 pointers approach : difference between end and start +1 > 5

if the element is in the list then we need to consider it in the list that we are returning
if the element is not there in the list then we return the element that

*/

// TC : O(n) + O(k)
// Space : 0(1)
// TODO : Optimize further on next iteration. Do the priority queue solution and BS solution.
// closest BS solution is the best solution.

// tc : Olog(n-k)
// space : O(1)
func findClosestElements(arr []int, k int, x int) []int {
	low := 0
	high := len(arr) - k - 1
	for low < high {
		mid := high + low/2
		diffLow := x - arr[mid]
		diffHigh := arr[mid+k] - x
		if diffLow < diffHigh {
			high = mid
		} else {
			low = mid + 1
		}
	}
	return arr[low : low+k]
}

// func findClosestElements(arr []int, k int, x int) []int {
//     //if len(arr) == 1 && k == 1 { return []int{}}

//     start := 0
//     end := len(arr)-1

//     // if start == end {
//     //     return arr
//     // }
//     diffStart := 0

//     for (end - start) + 1 > k {
//         if x < arr[start] { // instaed we can take absolute value here
//             diffStart = arr[start] - x
//         }else{
//             diffStart = x - arr[start]
//         }

//         diffEnd := arr[end] - x
//         if diffStart > diffEnd {
//             start++
//         }else{
//             end--
//         }
//     }
//     return arr[start:end+1] // can also loop over and add it to an array to return the elements

// }
