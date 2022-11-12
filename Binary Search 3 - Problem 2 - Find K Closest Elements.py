"""
FAANMG Problem #89 {Medium}  

658. Find K Closest Elements

TC : O(log(n-k) +k) ---> where n is the total number of elements in the array and
k is the kth number of elements that needs to be return. Binary search is perform on n-k elements.
SC : O(1)

Did this code successfully run on Leetcode : Yes

Binary Search
1. Motive here is to find the beginning of the valid range of k elements.
2. Possible beginning can be from the index 0 to n-k. n-k as n-k+k will is the only last valid range available.
3. Perform the binary search from n = 0  to n-k range find the beginning of the valid range.
4. Find the mid then calculate the dist-difference of mid and mid+k elements from the x if dist-difference of mid is 
greater than correct start point is present on left, otherwise on right.
5. Once the correct start point is found, return low to low+k elements

@name: Rahul Govindkumar_RN27JUL2022
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        n = len(arr)
        
         # Set the boundaries, low as 0 and high as n - k as we are looking for the starting index of the range
        low =0
        high = n-k
        
        # going over the list until low and high doesn't cross each other
        while(low < high):
            mid = low + (high-low)//2

            """
            calculate the distance from mid and decide which way to go
            distL is the distance from x from this element and distR is (mid + k)th element
            we do this in order to check for element which could have a smaller dist with x      
            """          
            
            distL = x - arr[mid]
            distR = arr[mid+k] - x
            
            # whichever dist is greater, we move closer from that side towards the other end
            
            if distL > distR:
                low =mid + 1
                
            else:
                high = mid
                
        return arr[low:low+k]
    
"""
Heap Approach

"""    

class HeapPriorityQueue:
    def __init__(self,value,nums):
        self.value = value
        self.nums = nums
        
    def __gt__(self,other):
        # while comparing the elements from the Hashmap, if the differnce is same, then we take the value with lower index
        if self.nums[self.value] == self.nums[other.value]:
            return self.value < other.value
        
        # if not, then simply return the lower value out of both
        return self.nums[self.value] < self.nums[other.value]

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        # hashmap to store the differnce in values and using index as the key
        nums = {}
        n = len(arr)

        for i in range(n):
            nums[i] = abs(arr[i] - x)
            
            
        maxHeap = []
        
        #fill elements in the heap using max-heap of len k
        for i in range(n):
            heapq.heappush(maxHeap, HeapPriorityQueue(i,nums))
            
            # if we reach the size of k, then remove the top element as we are looking for k closet elements, thus they will have lowest values
            if len(maxHeap) > k:
                heapq.heappop(maxHeap)
        
        res = []
        # remove values from the heap and store in res list
        while maxHeap:
            temp = heapq.heappop(maxHeap).value
            res.append(arr[temp])
        # sort the list as it will take k log k
        res.sort()
        return res
    

"""
Two Pointer Sol

"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        low =0\
        high = len(arr) -1
        
        # traversing until we have the difference between low and high as k elements
        while k < (high - low + 1):
            # find the absolute difference between the element x and at that index
            distL = abs(x - arr[low])
            distH = abs(x - arr[high])

            # whichever dist is greater, move from that point towards the middle
            if distL >  distH:
                low += 1
            else:
                high -= 1
         # after finding the range, put the elements in the res list and return
        res = []
        for i in range(low, high+1):
            res.append(arr[i])
        return res
        