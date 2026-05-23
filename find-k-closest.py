# binary search
# but im not trying to find x, im trying to find the range of k elements
# therefore we do the binary search on the starting index of range of k elements

# time: O(log(n-k)) - total size of search space is N-k
# space: O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # we are trying to find the start index of the window
        left = 0
        right = len(arr)-k
        
        while left < right:
            mid = (left+right)//2
            # the left edge candidate is further away from target than the right edge candidate
            # so move right
            if x - arr[mid] > arr[mid + k] - x:
                left = mid+1
            # the right edge candidate is further, so move left
            elif x - arr[mid] <= arr[mid + k] - x:
                right = mid

        return arr[left : left + k] 



# two pointer
# time: O(n)
# space: O(k) if count memory of output list
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        l = 0
        r = n-1
        while r - l >= k:
            distL = abs(arr[l]-x) 
            distR = abs(arr[r]-x)
            if distL > distR:
                l+=1
            else:
                r -= 1
        result=[]
        for i in range(l,r+1):
            result.append(arr[i])
        return result     

# heap solution
# time: O(Nlogk)+O(klogk) - for n elements we push to heap - push and pop take logk
# sorting the output is klogk
# space: O(k) - heap memory
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        max_heap = []
        
        for num in arr:
            dist = abs(num - x)
            # Python's heapq is a min-heap. 
            # To eject the furthest element (max distance), we push negative values.
            # Tie-breaker: if distances are equal, a larger num is 'further' (worse), 
            # so we pass -num to pop the larger number first.
            heapq.heappush(max_heap, (-dist, -num))
            
            # Keep the heap size bounded to k
            if len(max_heap) > k:
                heapq.heappop(max_heap)
                
        # Pull the remaining elements out of the heap and sort them ascending
        res = [-num for _, num in max_heap]
        res.sort()
        
        return res

# heap=[(-1,-10),(0,-11),(-1,-12)]
# x=11, k=3
#  0 1 2  3  4
# [1,2,10,11,12]
#.            n
# dist = 10











