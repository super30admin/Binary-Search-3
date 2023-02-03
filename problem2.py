#time O(log(N))
#space O(1)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # left, right = 0, len(arr) 
        # while left < right:
        #     mid = (left + right) // 2
        #     if arr[mid]==x:
        #         left=mid
        #     if  arr[mid] < x:
        #         left = mid + 1
        #     else:
        #         right = mid
        # print(left,right)
        left, right = 0, len(arr) -k
        while left < right:
            mid = (left + right) // 2
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return arr[left:left + k]
        