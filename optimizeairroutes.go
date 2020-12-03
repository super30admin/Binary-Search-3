// Time Complexity : O(n2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
have a map of sum as target and pair of ids as value
for each in a
for each in b
check if map contains key equal to sum of distances if so append current pair to existing value
else create and append pair to map

create new array of indexes
for each element in map
if key <target add key to resInd
else if key == target return value of key from map
if len(resInd) is 0 return blank
else find max key from resInd
return value of that max key
*/
package main

import (
	"fmt"
)

func optimizedAirRoute(a, b [][]int, target int) [][]int {
	m := make(map[int][][]int)
	for i:=0;i<len(a);i++ {
		for j:=0;j<len(b);j++ {
			sums, e := m[a[i][1] + b[j][1]]
			if e {
				sums = append(sums, []int{a[i][0], b[j][0]})
				m[a[i][1] + b[j][1]] = sums
			} else {
				m[a[i][1] + b[j][1]] = [][]int{{a[i][0], b[j][0]}}
			}
		}
	}

	resInd := []int{}
	for key, element := range m {
		if key < target {
			resInd = append(resInd, key)
		} else if key == target {
			return element
		}
	}
	if len(resInd) == 0 {
		return [][]int{}
	}
	max := -1
	for i, e := range resInd {
		if i==0 || e < max {
			max = e
		}
	}
	return m[max]
}

func MainOptimizedAirRoutes() {
	fmt.Println(optimizedAirRoute([][]int {{1, 3}, {2, 5}, {3, 7}, {4, 10}}, [][]int {{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 10)) //expected [[2, 4], [3, 2]]
}