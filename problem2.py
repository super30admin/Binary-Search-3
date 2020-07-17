# # using two pointers and binary search
# # METHOD 1
# class Solution:
#     def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
#         n = len(arr)
#         low, high = 0, n-k-1
        
#         while low<=high:
#             mid = low + (high-low)//2
#             low_dist = abs(arr[mid] - x)
#             high_dist = abs(arr[mid+k] - x)
            
#             if arr[mid] == arr[mid+k]:
#                 if x>arr[mid]:
#                     low = mid + 1
#                 else:
#                     high = mid
#             elif low_dist > high_dist:
#                 low = mid+1
#             else:
#                 high = mid-1
        
#         return arr[low:low+k]


# using two pointers and binary search
# METHOD 2
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        low, high = 0, n-k-1
        
        while low<=high:
            mid = low + (high-low)//2
            low_dist = abs(arr[mid] - x)
            high_dist = abs(arr[mid+k] - x)
            
            if arr[mid] == arr[mid+k]:
                flag = False
                ptr = mid+1
                while ptr<n:
                    if arr[ptr] != arr[mid]:
                        flag = True    
                        if abs(arr[ptr]-x) < high_dist:
                            low = ptr-k
                        else: 
                            high = mid - 1
                        break
                    ptr+=1
                if not flag:
                    return arr[low:low+k]
            elif low_dist > high_dist:
                low = mid+1
            else:
                high = mid-1
        
        return arr[low:low+k]


# O(n) find distance
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        distance = []
        for elem in arr:
            distance.append((abs(x-elem), elem))
        
        # O(nlogn) sorting
        distance = sorted(distance)
             
        # O(k) populating answer where k<n
        answer, i = [], 0
        while i<k:
            answer.append(distance[i][1])
            i+=1    
        return sorted(answer)


# O(n) find distance
# using heaps
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        distance = []
        for elem in arr:
            heapq.heappush(distance, (-abs(elem-x), -elem))
            if len(distance)>k:
                heapq.heappop(distance)
        
        answer = []
        while k:
            answer.append(-heapq.heappop(distance)[1])
            k-=1

        return sorted(answer)


# O(k) time
# using two pointers
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        high = len(arr)-1
        if high == k-1:
            return arr
        low = 0
        
        while (high-low > k-1):
            if abs(arr[high]-x) < abs(arr[low]-x):
                low += 1
            else:
                high -= 1
        
        return arr[low:high+1]


