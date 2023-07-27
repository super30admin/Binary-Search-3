# Time Complexity : O(log(n - k))
# Space Complexity : O(1)

# The code ran on LeetCode

# Perform binary search to get the starting index of the result. Update pointers such that we move towards the minimum distance.

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # Binary Search
        # l = 0; h = len(arr) - k
        # while l < h:
        #     mid = (l+h)//2

        #     distS = x - arr[mid]
        #     distE = arr[mid+k] - x

        #     if distS > distE:
        #         l = mid + 1
        #     else:
        #         h = mid
        # res = []
        # for i in range(k):
        #     res.append(arr[l + i])
        # return res

        # Two pointers
        l = 0; h = len(arr) - 1

        while h - l + 1 > k:
            distL = abs(arr[l] - x)
            distH = abs(arr[h] - x)
            if distL > distH:
                l+=1
            else:
                h-=1
        res = []
        for i in range(l, h+1):
            res.append(arr[i])
        return res