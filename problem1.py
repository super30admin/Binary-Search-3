# Time Complexity o(N)
# Space Complexity o(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0 

        high = len(arr)-1

        while((high - low) +1 > k):

            distlow = abs(arr[low] - x)
            distHigh = abs(arr[high] - x)

            if distlow > distHigh:
                low +=1
            else:
                high -=1



        return arr[low:high+1] 
