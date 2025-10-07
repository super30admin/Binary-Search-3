'''
Solution 1: Using Heaps
    - Maintain a Max-heap of size=k.
    - store pair of (absolute diff, element) in the max-heap while iterating over 
      input array. if size(heap)>k, pop the element
    - At the end, pop the elements from the heap and store them in a list. Sort
      the list which gives you the final answer.
Time complexity: N = total elements, k = k closest elements to find
    - O(Nlogk) , adding elements into max-heap
    - O(klogk), removing elements from heap and storing it to list
    - O(klogk), sorting the final answer list.
    Total = O({N+2k}logk) ~ O(Nlogk), worst case k = N
Space Complexity: O(k) - heap
'''
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        heap = [] # max heap on abs difference with size(heap) = k. 

        for i in range(len(arr)):
            heapq.heappush(heap,(-abs(x-arr[i]),-arr[i])) # negate the abs(diff) for max-heap
            if len(heap)>k:
                heapq.heappop(heap)
        
        closestElements = [None]*k

        for i in range(k):
            closestElements[i] = -heapq.heappop(heap)[1] 
        
        return sorted(closestElements)

'''
Solution 2: Binary search on starting index of the window of size = k
    - search space : 0 - len(arr)-k  -> indexes where we can place window start to
                                        accomodate the entire window of size = k
    - mid gives us start index of window => mid+k gives us right element to end of window 
    - check if I want to go the left search space i.e.
        (x-arr[mid]) <= arr[mid+k]-x
            - yes: move right --> mid (as mid still possible answer)
            - no: move left --> mid+1 (as mid checked for window_start, explore right sub-space)
    - At the end, left pointer gives us start of window of size=k
Time complexity: N = total elements, k = k closest elements to find
    Total = O(log(N-k)), binary search in range [0, N-k]
Space Complexity: O(1) 
'''
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr)-k # possible range of start index of window 
        mid = 0
        while left<right:
            mid = left + (right-left)//2  # mid gives us the start index of window

            # compare diff of 'x' with start of window to next (right) element from end of window
            if (x - arr[mid]) <= (arr[mid+k] - x): 
                # if right element from end of window is farther from 'x', move to left half
                right = mid # 'mid' element is still valid answer for start
            else:
                left = mid+1 # definetly move away from mid. 


        return arr[left:left+k] # left pointer will point to start index of window
