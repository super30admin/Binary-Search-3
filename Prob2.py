# Time Complexity: O(log(n-k))
# Space Complexity: O(1)
# Approach ->
 

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        #Method 1 - get distance and use max heap to get the k elements
        # TC - O(N log N+ k Log k)
        import heapq
        max_heap=[]
        for num in arr:
            diff = abs(num - x)
            if len(max_heap) < k:
                heapq.heappush(max_heap, (-diff, num))
            else:
                if diff < -max_heap[0][0]:
                    heapq.heappop(max_heap)
                    heapq.heappush(max_heap, (-diff, num))

        result = [num for _, num in max_heap]
        return sorted(result) #k log k 


        #Method 2 - 2 pointers. TC-O(n-k)+O(k) SC - O(1)
        #Here, take 2 pointers, low and high. Do 1 pass, with abs() dist of each element from x. if low dist is more low+=1 else high-=1. Do this till you find the range. Then return the elements in the range
        # low=0
        # high=len(arr)-1
        # while high-low+1>k: #finding elements in the range -> k elements -> O(n-k)
        #     distl=abs(x-arr[low])
        #     disth=abs(x-arr[high])
        #     if distl>disth:
        #         low+=1
        #     else:
        #         high-=1
        # return arr[low:high+1] #O(k)


        # Method 3 - Binary search to get left bound of the range of numbers -> O(log (n-k))
        #IMPORTANT NOTE- don't use abs() here, it will mess up in the case of identical elements.
        # low=0
        # high=len(arr)-k #the worst the lower bound can be is len(arr)-k elements. Anything after this will run out of elements.
        # while low<high:
        #     mid=low+(high-low)//2
        #     dist_start=x-arr[mid] #left distance
        #     dist_end=arr[mid+k]-x #right distance
        #     if dist_start>dist_end: #is left distance>right distance then, move right
        #         low=mid+1
        #     else: #else move left
        #         high=mid
        # return arr[low:low+k] #in the end, low and high will meet, so either works here..
            
            