
/*
    approach: find the start position using binary search
    time : o(logn-k)
    space: o(1)
*/
func findClosestElements(nums []int, k int, x int) []int {
    left := 0
    right := len(nums)-k
    for left <= right {
        
        mid := left + (right-left)/2
        if mid + k >= len(nums) {break}
        
        startDist := x-nums[mid]
        endDist := nums[mid+k]-x
        if startDist > endDist {
            left = mid+1
        } else {
            right = mid-1
        }
    }
    return nums[left:left+k]
}

/*
    approach: 2 pointers
    - left ptr at 0
    - right ptr at n-1
    - while the distance between left and right != k
        - i.e until we do not have a window of size k
        - get leftDist to x
        - get rightDist to x
        - whoever is farther from x, move away from that value 
            - if rightDist is farther from x compared to leftDist, then right--
            - else left++
        - If the distance is the same, then move away from bigger value
    - once we have a valid window of size k
    - then loop from left to right and populate the result arr
    - time: o(n-k)+o(k)
    - space: o(1)
*/
// func findClosestElements(nums []int, k int, x int) []int {
//     left := 0
//     right := len(nums)-1
    
//     for right - left + 1 != k {
//         leftDist := x - nums[left]
//         rightDist := nums[right] - x
//         if leftDist > rightDist {
//             left++
//         } else {
//             right--
//         }
//     }
//     return nums[left:right+1]
// }

// func abs(x int) int {
//     if x < 0 {return x * -1}
//     return x
// }

/*
    approach: The infamous kth smallest/largest question with heap
    - store a pair(val, distAway) in a maxHeap
    - For each n elements
    - Calc the distance : arr[n] - x
    - Create a pair {val, distAway}
    - Store in maxHeap ( maxHeap sorted by distAway so the farthest pair will be on the top )
    - If the maxHeap size > k heap.pop()
    - Once all the elements are done,
    - The maxHeap will be left with k pairs that are the closest to x
    - Loop over maxHeap items and store them in result array and return
    
    total time = o(nlogk) for creating heap + o(klogk) for heap pop + o(klogk) for sorting
    space: o(k) - in maxHeap at worse, we will store k elements

*/
// func findClosestElements(nums []int, k int, x int) []int {
//     mx := &maxHeap{items: [][]int{}}
//     // o(nlogk) time
//     // o(k) space
//     for i := 0; i < len(nums); i++ {
//         heap.Push(mx, []int{nums[i], abs(nums[i]-x)})
//         if len(mx.items) > k {heap.Pop(mx)}
//     }
//     out := []int{}
//     // o(k) time
//     for len(out) != k {
//         popped := heap.Pop(mx).([]int)
//         out = append(out, popped[0])
//     }
//     // o(klogk) time
//     sort.Ints(out)
    

//     return out
// }


// type maxHeap struct{
//     items [][]int // {val, dist}    
// }

// func (mx *maxHeap) Less(i, j int) bool {
//     iDist := mx.items[i][1]
//     jDist := mx.items[j][1]
//     if iDist == jDist {
//         // sort by value in desc order; i should be placed before j if i > j
//         return mx.items[i][0] > mx.items[j][0]
//     }
//     return iDist > jDist
// }
// func (mx *maxHeap) Swap(i, j int) {
//     mx.items[i], mx.items[j] = mx.items[j], mx.items[i]
// }
// func (mx *maxHeap) Len() int {return len(mx.items)}
// func (mx *maxHeap) Push(x interface{}) {
//     mx.items = append(mx.items, x.([]int))
// }
// func (mx *maxHeap) Pop() interface{} {
//     out := mx.items[len(mx.items)-1]
//     mx.items = mx.items[:len(mx.items)-1]
//     return out
// }




/*
    approach: brute force with 2 binary searches and with 2 pointers
    - find the closest left and right value to x
        - left may be closer or right maybe closer, therefore find both
        - then pick the closer one out of the two.
    - then we know for sure that out of the above two positions, we have 1 closest 
    - therefore add that closest element to our output arr
    - Then run 2 pointers from that idx position ( p1 = idx-1 and p2 = idx+1 )
        - p1 goes back
        - p2 goes forward
    - which ever pointer is closer to x, add that element to the output array and move that pointer back/forward
        - as long as both pointers are inbound and our output arr size != k.
    - we could get into a situation where p1 or p2 does out of bound and our output size != k ..
        - example: x = -1 k = 5, nums=[1,2,3,4,5]
        - so handle this case by checking which ever ptr is inbound and using those values; while out array != size k.
    
*/
// time: o(2logn) + o(n) + o(nlogn)
// space: o(1)
// func findClosestElements(nums []int, k int, x int) []int {

//     // 2 binary searches to find which idx to start our 2 mid pointers from
//     // therefore o(logn) + o(logn)
//     leftMostIdx := leftMostOrEqualToX(x, nums)
//     rightMostIdx := rightMostOrEqualToX(x, nums)
    
//     leftVal := nums[leftMostIdx]
//     rightVal := nums[rightMostIdx]
//     leftDiff := x-leftVal
//     rightDiff := rightVal-x
//     idx := rightMostIdx
//     if leftDiff <= rightDiff {
//         idx = leftMostIdx
//     }
    
//     out := []int{nums[idx]}
//     p1 := idx-1
//     p2 := idx+1
    
    
//     // o(n) worst case we select all elements because k == len(nums)
//     for len(out) != k && p1 >= 0 && p2 < len(nums) {
//         p1Diff := x-nums[p1]
//         p2Diff := nums[p2]-x
//         if p1Diff == p2Diff {
//             out = append(out, nums[p1])
//             p1--
//         } else if p1Diff < p2Diff {
//             out = append(out, nums[p1])
//             p1--
//         } else {
//             out = append(out, nums[p2])
//             p2++            
//         }
//     }
    
//     // o(k)
//     for len(out) != k {
//         if p1 >= 0 {
//             out = append(out, nums[p1])
//             p1--
//         } else {
//             out = append(out, nums[p2])
//             p2++            
//         }
//     }
    
//     // worst case; we have selected all elements nums array
//     // therefore time : o(nlogn)
//     sort.Ints(out)
//     return out
    
// }

// func leftMostOrEqualToX(x int, nums []int) int {
//     if x < nums[0] {return 0}
//     if x > nums[len(nums)-1] {return len(nums)-1}
//     idx := -1
//     left := 0
//     right := len(nums)-1
//     for left <= right {
//         mid := left+(right-left)/2
//         if nums[mid] <= x {
//             if nums[mid] == x{return mid}
//             idx = mid
//             left = mid+1
//         } else {
//             right = mid-1
//         }
//     }
//     return idx
// }

// func rightMostOrEqualToX(x int, nums []int) int {
//     if x < nums[0] {return 0}
//     if x > nums[len(nums)-1] {return len(nums)-1}
//     idx := -1
//     left := 0
//     right := len(nums)-1
//     for left <= right {
//         mid := left+(right-left)/2
//         if nums[mid] >= x {
//             if nums[mid] == x{return mid}
//             idx = mid
//             right = mid-1
//         } else {
//             left = mid+1
//         }
//     }
//     return idx
// }
