#Time Complexity: O(log(n-k))
#Space Complexity: O(1)
#Using Binary Search
#We are taking binary search for the range. We start at low=0 to high=length-k. Then check which side is heavy and update low/high accordingly
#this will give starting point for that range
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low=0
        high=len(arr)-k
        mid=0
        while low<high:
            mid=low+(high-low)//2
            start_dist=x-arr[mid]
            end_dist=arr[mid+k]-x
            if start_dist>end_dist:
                low=mid+1
            else:
                high=mid
        
        return arr[low:low+k]


#Time complexity: O(n-k)
#Space complexity: O(1)
#Using 2 pointers:
#start pointer at 0 and end pointer at len-1
#value at start is farther away from x, move range closer - start++
#value at end is farther away from x, move range closer - end++
#if len of range is k, return

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        start=0
        end=len(arr)-1
        while(start<end):
            if (end-start+1)==k:
                break
            if abs(x-arr[start])>abs(x-arr[end]):
                start=start+1
            else:
                end=end-1
        return arr[start:end+1]


#Using heap
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        inpheap=[]
        result=[]
        for i in arr:
            diff=abs(i-x)*-1
            if len(inpheap)>0:
                d,el=heapq.heappop(inpheap)
                if diff==d and el<i:
                    heapq.heappush(inpheap,(d,el))
                else:
                    heapq.heappush(inpheap,(d,el))
                    heapq.heappush(inpheap,(diff,i))  
            else:
                heapq.heappush(inpheap,(diff,i))
            if len(inpheap)>k:
                heapq.heappop(inpheap)
        print(inpheap)
        for j in range(len(inpheap)):
            diff,element=heapq.heappop(inpheap)
            result.append(element)
        return sorted(result)