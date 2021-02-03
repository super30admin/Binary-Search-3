# TC: log(N) + O(k)
# SC: O(1)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        n = len(arr)
        if x >= arr[-1]:
            return arr[n-k:]
        if x <= arr[0]:
            return arr[:k]
        def binarySearch(arr, start, end, x):
            
            while start <= end:
                
                mid = start + (end-start) // 2
                if arr[mid] == x:
                    return mid
                elif arr[mid] > x:
                    end = mid - 1
                else:
                    start = mid + 1
            return end if abs(x - arr[end]) <= abs(x - arr[start]) else start
        
        idx = binarySearch(arr, 0, n-1, x)
        left = idx - 1
        right = idx + 1
        ct = 1
        result = []
        result.append(arr[idx])
        while ct<k and left >= 0 and right < n:
            if abs(x - arr[left]) <= abs(x - arr[right]):
                result.append(arr[left])
                left -= 1
                ct += 1
            else:
                result.append(arr[right])
                right += 1
                ct += 1
        
        if right >= n:
            while ct < k:
                result.append(arr[left])
                left -= 1
                ct += 1
        if left < 0:
            while ct < k:
                result.append(arr[right])
                right += 1
                ct += 1
        return arr[left+1:right]