# // Time Complexity :O(log(n-k))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
class solution:
    #Approach 1
    def kthclosest(self, nums, x, k):
        distanceMap= {}

        for i in range(len(nums)):
            distanceMap[i] = abs(x-nums[i])
        
        kthHeap  = []
        result = []
        for key, val in enumerate(distanceMap):
            
            heapq.heappush(kthHeap, (-val, key))

            if len(kthHeap) >k:
                heapq.heappop(kthHeap)
        
        while kthHeap:
            val, idx = heapq.heappop(kthHeap)
            result.append(idx)
        
        return result.sort()
    
    #Approach 2
    ## time complexity O(nlogk) 
    ## space O(k)
    ## because we have a size of k for our heap.
    ## We maintian a heap of size k at all times. the heap is based on the distance from our x. we store the number. now from the next number onwards, 
    ##distance of the new number is less than that of top of heap. if it is then we pop the element and push the new element. The logic is the the heap conatins the smallest elements at all time so if an element that is too huge comes in 
    ## it wont even get in to the ehap/ at the same time if we got too small elements, by the time closest elements come in even the small elements will be popped out. 
    ## then we sort the heaqp and return 
    def alternateHeap(self, arr, k, x):
        kthHeap = []

        for i in range(k):
            heapq.heappush(KthHeap, arr[i])
        
        for i in range(k, len(arr)):
            if (abs(x-arr[i])) < abs(x- kthHeap[0]):
                heapq.heappop(kthHeap)
                heapq.heappush(kthHeap, arr[i])
        
        return sorted(kthHeap)

    #Approach 3
    ## time O(n)
    ## space O(1)

    ## we perform two pointer until the difference between both pointers is k (high-low+1 = k). if the difference of x and 
    ## low is higher than difference high and x we move the low+=1 else we move high-=1. In the end we return arr[low:high+1]
    def twoPointer(self, arr, k, x):
        low = 0
        high = len(arr)-1

        while high - low >= k:
            if abs(x-arr[high]) < abs(x-arr[low]):
                low+=1
            else:
                high-=1
        
        return arr[low:high+1]

    #Approach 4
    ## time complexity O(log(N-k))
    ## space O(1)
    ## This is the most optimal solution. In this we just care about the range , we are not finding any numbers.
    ## we have a low pointer at 0 and high pointer at N-k. we do a binary search where we get distance of start pointer and dist of end pointer. 
    ## for distance of end pointer we take an extra element because if the extra element is same as the previous then we need to consider that as it is possible that the start poiinter distance may be greater.
    ## if distStart > distEnd : we move low-> mid+1 else if dist<= distENd --> high = mid. thisd way we are guaranteed to find the lowest pointer closest to x. 
    ##we return low and low+k
    def binary_search_range(self, arr, k, x):

        low = 0 
        high = len(arr)-k

        while low < high:
            mid = low +(high-low)//2

            distStart = x- arr[mid]
            distEnd = arr[mid+k] - x
            if distStart > distEnd:
                low = mid+1
            else:
                high = mid
        
        return arr[low:low+k]

    #Approach 5 
    ## time -> O(logN) +O(k)
    ## this is also a binary search approach which is very tricky. we fist find the number that is closest to the actual element. 
    #  to find the closest binary, we see if mid is greater than x, then we bring high to mid and x is greater than mid we bring
    ## low to mid. if we find element then return mid. the breaking condition is low+1 < high, this is because we could be in a 
    ## deadlock if the elemnt is not present in the array and our low and high wont reduce as we bring them to mid all the time. 

    ## for the two pointer approach. we see if end-start-1 <k that is elements between start and end shouild be k 
    ## there is a chance that elements can go out of bounds. if they do we move the opposite pointer. and if the difference of x and start is 
    ## smaller than difference of x and end , we move start else we move end
    ## and since the start is 1 step back, we always return start+1 to end.
    def binary_search_two_pointer(self, arr, k , x):
        
        start = self.binary_helper(arr,x)

        end = start+1

        while end-start-1 <k:

            if start == -1:
                end+=1

            if end == len(arr) or x-arr[start] <= arr[end]-x:
                start-=1
            else:
                end+=1
            
        return arr[start+1:end]
    
    def binary_helper(self, arr, x):
        low = 0
        high = len(arr)-1

        while low+1 <high:
            mid = low +(high-low)//2

            if arr[mid] == x:
                return mid
            
            if arr[mid] < x:
                low = mid
            else:
                high = mid
        
        return low

