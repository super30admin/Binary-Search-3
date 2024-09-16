# O(LOG(N) + K) TIME and O(1) SPACE
# All test cases didn't pass

class Solution:
    def findClosestElements(self, arr,k,x):
        x_pos = self.binarySearch(arr,x,0,len(arr)-1)
        left = x_pos-1
        right = x_pos+1
        
        if left < 0:
            return arr[:k]
        elif right > len(arr):
            return arr[len(arr)-1:len(arr)-k:-1]
        
        while left >=0 and right < len(arr):
            if right - left + 1 == k:
                break
            if right - left + 1 == k + 1:
                right -= 1
                break
            left -= 1
            right += 1

        return arr[left:right+1]
            
    def binarySearch(self,arr,target,left,right):
        
        if target <= arr[0]:
            return 0
        
        if target >= arr[-1]:
            return len(arr) - 1
        
        while left <= right:
            mididx = (left + right) // 2
            
            if arr[mididx] == target:
                return mididx
            if target > arr[mididx]:
                if mididx < len(arr) - 1 and target < arr[mididx+1]:
                    return mididx if target - arr[mididx] <= arr[mididx+1] - target else mididx+1
                left = mididx + 1
            else:
                if mididx > 0 and target > arr[mididx - 1]:
                    return mididx if arr[mididx] - target <= target - arr[mididx - 1] else mididx - 1
                right = mididx
            
# s = Solution()
# print(s.findClosestElements([1,2,3,4,5],4,10))
        
        
        
        