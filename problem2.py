# Approach1: Heap
# Time Complexity: O(nlogk)
# The algorithm efficiently processes each of the n elements, maintaining a heap of size k, resulting in a logarithmic factor with respect to k.
# Space Complexity: O(k)
# The heap and the result list both consume space proportional to k.
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        max_heap = []

        for num in arr:
            diff = abs(num - x)
            heapq.heappush(max_heap, (-diff, -num))
            if len(max_heap) > k:
                heapq.heappop(max_heap)

        result = [-num for _, num in max_heap]
        result.sort()
        return result


# Approach2: Two Pointers
# Time Complexity: O(n)
# The while loop runs in O(n - k) time, and slicing the array takes O(k) time. So the overall time complexity is O(n).
# Space Complexity: O(k)
# The space is used for the output array of k elements, and the space complexity is O(k).

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        left, right = 0, n-1

        while right-left >= k:
            if abs(arr[left]-x) > abs(arr[right]-x):
                left += 1
            else:
                right -= 1

        return arr[left:right+1]
    

# Approach3: Binary Search
# time complexity: O(log(n-k) + k)
# space complexity: O(k)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if k == len(arr):
            return arr
            
        # right = len(arr)-k because:
        # - we need a window of size k
        # - rightmost valid starting position is (len(arr)-k)
        # - starting after this would make window exceed array bounds
        left = 0
        right = len(arr) - k
        
        while left < right:
            mid = (left + right) // 2
            
            # arr[mid+k] instead of arr[mid+k-1] because:
            # - [mid, mid+k-1] is our current k-sized window
            # - arr[mid+k] is first element AFTER window
            # - we compare window boundaries to see if we should shift window
            #
            # For example with arr=[1,2,3,4,5], k=3, x=3:
            # if window is [1,2,3], we compare:
            # - distance from x=3 to left=1 
            # - distance from x=3 to after_window=4
            
            # x - arr[mid] > arr[mid + k] - x means:
            # - left boundary is FURTHER from x than right boundary
            # - so current window and any window starting before mid is bad
            # - that's why we can safely do left = mid + 1
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            
            # right = mid instead of mid-1 because:
            # - current window might be the best answer
            # - if we did mid-1 we might skip the optimal window
            # - example: arr=[1,2,3,4,5], k=3, x=3
            #   when we find window [2,3,4] is good
            #   we can't eliminate position 2 (mid)
            else:
                right = mid
                
        return arr[left:left + k]