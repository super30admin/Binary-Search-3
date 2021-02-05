// Time Complexity : O(x + logk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
	Find the closest elemnet using binary search this will give a value that is closet but higher than
	the number of interest. Now calculate the diffrence between the previous elemnet so that we consider the
	number which is least far. Once this index is found and passed back to the main program in the main program
	find the remaining numbers to the left and to the right to fit in tne x.
	Take care of the boundary conditions.

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        # edge
        if not arr: return result
        closest = self.binarySearch(arr, x)
        result.append(arr[closest])
        left = closest -1
        right = closest + 1
        while k > 1:
            if left < 0:
                result.append(arr[right])
                right += 1
            elif right == len(arr):
                result.insert(0, arr[left])
                left -= 1
            else:
                if x - arr[left] > arr[right] - x:
                    result.append(arr[right])
                    right += 1
                else:
                    result.insert(0, arr[left])
                    left -= 1
            k-=1
        return result
    def binarySearch(self, arr, x):
        low, high = 0, len(arr) - 1
        while low < high:
            mid = low + (high - low)//2
            if arr[mid] == x: return mid
            elif arr[mid] < x:
                low = mid + 1
            else:
                high = mid
        if low == 0: return low
        if abs(arr[low] - x) < abs(arr[low-1]-x): return low
        return low-1

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
	Two pointer approach: Move the pointers on either side untill the diffrence in the pointers dont cross less than k
	Increment L and H pointers based on how far they are from the target number. return the arr from l to h+1
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        # edge
        if not arr: return result
        l , h = 0 ,len(arr) -1
        while(h-l+1 > k):
            Ldistance = abs(arr[l] - x)
            Rdistance = abs(arr[h] - x)
            if Ldistance > Rdistance:
                l += 1
            else:
                h -= 1
        return arr[l:h+1]
        
            