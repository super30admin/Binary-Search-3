class Solution:
    # Two pointer solution
    # Time Complexity: O(n-k)
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        n  = len(arr)
        l = 0
        r = n -1
        # while loop until number of integers between left and right pointers are gretaer than the "K"
        #  return those intergers, which will remains between both pointers after the end of the while loop
        while(r - l +1 > k):
            # distance to left pointer from x
            distanceLeft = abs(arr[l] - x)
            # distance to right pointer from x
            distanceRight = abs(arr[r] - x)

            # which pointer have greater distance, move than pointer
            if(distanceLeft > distanceRight ):
                l = l +1
            else:
                r = r -1
               
        for i in range(l,r+1):
            result.append(arr[i])
        
        
        return result


    # Binary Search solution
    # Time complexity: O(log(n-k))
    def findClosestElements2(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        n  = len(arr)
        low = 0
        high = n - k
        while (low < high):
            mid = int(low + ((high - low)/2))
        
            distanceStart = x - arr[mid]
            distanceEnd = arr[mid+k] - x
            if (distanceStart > distanceEnd ):
                low = mid +1
            else:
                high = mid
               
        for i in range(low,low+k):
            result.append(arr[i])
        
        
        return result