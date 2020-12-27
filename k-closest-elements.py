# time-O(n-k)
# space-O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # two poitner
        # i=0
        # j=len(arr)-1
        # while j>=0 and i<len(arr):
        #     if j-i+1==k:
        #         return arr[i:j+1]
        #     if abs(arr[i]-x)>abs(arr[j]-x):
        #         i+=1
        #     else:
        #         j-=1

        ###bnary searh
        # time- O(log(n-k))
        # space-O(1)
        # des
        low = 0
        high = len(
            arr) - k  # have to find the first element so take high as len(arr)-k so that it wont cross the bounds
        while low < high:
            first = low + (high - low) // 2
            last = first + k - 1  # adding +1 because the indices start from 0
            if first > 0 and x - arr[first - 1] <= arr[
                last] - x:  # first-1 is to find a duplicate, if yes keep moving left
                high = first - 1
            elif last > 0 and x - arr[first] > arr[
                last + 1] - x:  # last-1 is to find a duplicate, if yes keep moving right
                low = first + 1
            else:
                return arr[first:first + k]
        return arr[low:low + k]