# Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

# Time Complexity : O(log n)
# Space Complexity :o(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

'''
first apprach: brute force, find all elements within the given range 
and sort them by their absolute difference with target.
Then return the first k elements of this sorted list.
Time complexity: O(n log n) because of sorting.
 
second appraoch: heap, maintain a min heap of size k.
Time complexity: O(n log k) because of heap operations.

Third appraoch: maintain two pointers,
Time complexity: O(n-k) because of two pointer operations.

Fourth appraoch: binary search, maintain two pointers, one pointing to the leftmost element 
greater than or equal to target, and the other pointing to the rightmost element 
less than or equal to target.
Finally, return the elements from the left pointer to the right pointer in sorted order.
Time complexity: O(log n) because of binary search.
'''


#### 2 pointer approach

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        left = 0
        right = n-1

        while(right - left >= k):
            distL = abs(arr[left] - x)
            distR = abs(arr[right] - x)

            if distL > distR:
                left+=1
            else:
                right -=1
        
        res = []
        for i in range(left,right+1):
            res.append(arr[i])
        
        return res

#TC: O(n-k) + O(k) for 2 pointer and k for loop to append into res = O(n)
# SC: O(k) k for res



########### heap approach


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        pq = []

        for num in arr:
            dist = abs(num - x)
            heapq.heappush(pq,(-dist,-num)) 
            # taking a tuple sort it in desc order of dist and if dist is equal we sort based on the num
            # choose to keep the smallest no and remove large ones

            if(len(pq) > k):
                heapq.heappop(pq)

        res = []
        while k:
            dist,num = heapq.heappop(pq)
            res.append(-num)
            k-=1

        res.sort()
        return res

#TC: O(n log k) for heap of size k
# SC: O(k) k for res


############# Binary Search approach for start index in n-k range


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        low = 0
        high = n-k

        while(low < high):
            mid = low + (high - low)//2

            distL = x- arr[mid]
            distR = arr[mid+k] - x

            if distL > distR:
                low = mid+1
            else:
                high = mid


        res = []
        for i in range(low,low+k):
            res.append(arr[i])

        res.sort()
        return res

#TC: O(log(n-k)) for BS
# SC: O(k) k for res