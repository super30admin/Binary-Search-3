class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        if not arr and len(arr) < 1:
            return

        low = 0
        high = len(arr)-1

        while high >= low and high - low > k-1:

            distL = abs(x - arr[low])
            distR = abs(x - arr[high])

            if distL > distR:
                low += 1

            elif distL <= distR:
                high -= 1

        return arr[low:high+1]