#I used a combination of binary search and a two-pointer technique. First, I employed a binary search to find the position pos where x would be inserted in arr while maintaining the sorted order. This position helps in determining the initial range of indices to explore. Then, I set up two pointers, left and right, starting at pos-1 and pos, respectively. By expanding these pointers outward, I maintained a window of size k that includes the k closest elements to x. If left is out of bounds or the element at right is closer to x than the element at left, I adjust the pointers accordingly. This approach ensures that I always have the k closest elements in the resulting subarray. The time complexity of this solution is O(log n + k), where O(log n) is due to the binary search and O(k) is for adjusting the pointers. The space complexity is O(1) since no additional space is used beyond the pointers and variables.

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        if len(arr)==k:
            return arr
        
        def binarySearch(x):
            left=0
            right=len(arr)-1
           

            while left<=right:
                mid=(left+right)//2
                if arr[mid] ==x:
                    return mid
                elif arr[mid] <x:
                    left=mid+1
                else:
                    right=mid-1 
            return left

        pos=binarySearch(x)
        left=pos-1
        right=pos

        while right-left-1<k:
            if left == -1:
                right += 1
                continue
            if right ==len(arr) or abs(arr[left] - x) <= abs(arr[right] - x):
                left=left-1
            else:
                right=right+1
        return arr[left +1 :right]

        