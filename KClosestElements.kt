// In this problem, we are trying to find the k closest elements to x. We are using binary search to find the starting point of the k closest elements. 
// We compare the distance of the middle element to x with the distance of the element at mid + k to x. If the middle elemeent is farther from x than the element at mid + k then we know
// that the k closest elements must be to the right of mid, so we move the low pointer to mid + 1. Otherwise, we move the high pointer to mid.
// Time complexity: O(log (n-k)) because we are performing binary search on the range of n-k.
// Space complexity: O(1)

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        
        val n = arr.size
        var low = 0 
        var high = n - k

        while(low < high) {
            var mid = low + (high - low)/2

            var distS = x - arr[mid]
            var distE = arr[mid + k] - x

            if(distS > distE) {
                low = mid + 1
            } else {
                high = mid
            }

        }

        val result = mutableListOf<Int>()
        for(i in low until low + k) {
            result.add(arr[i])
        }

        return result
    }
}