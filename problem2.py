class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) == 1: return arr
        #find the element and have 2 pointers on either side till you get k elements
        l = 0
        r = len(arr) - 1
        ind = -1
        while l < r:
            mid = l + (r-l)//2
            
            if arr[mid] < x:
                l = mid + 1
            else:
                r = mid
        
        
        res = []
        left = l-1
        right = l
        while k > 0:
            if left >= 0 and (right >= len(arr) or abs(arr[left] - x) <= abs(arr[right] - x)):
                res.append(arr[left])
                left -= 1
                k -= 1
            else:
                res.append(arr[right])
                right += 1
                k -= 1
        
        res.sort()
