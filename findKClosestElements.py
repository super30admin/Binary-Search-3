# Time Complexity : O(N)  O(n-k+k) -> O(n) for TWO POINTER.. O(logN + k) s
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        """
        Two pointer solution - check distance at each val from the left and right side of arr.
        Move the bigger distance (left -> left+1 if left is bigger than right 
                                  right -> right-1 )
            *until the length of the two pointers is k*
        """
        res = [] 
        
        if not arr:
            return res
        
        left = 0 
        right = len(arr)-1
        
        while right - left >= k:
            leftDistance = abs(x - arr[left])
            rightDistance = abs(x - arr[right])
            
            if leftDistance > rightDistance:
                left += 1
            else:
                right -= 1
                
        for i in range(left, right+1):
            res.append(arr[i])
            
        return res

################################################################
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        res = deque([]) 
        
        if not arr:
            return res
        
        closest = self.binarySearch(arr, x)
        res.append(arr[closest])
            
        left = closest - 1
        right = closest + 1
        
        while k > 1:
            #check bounds
            #if left is outtabounds
            if left < 0:
                res.append(arr[right])
                right += 1
            #if right is outtabounds
            elif right == len(arr):
                res.appendleft(arr[left])
                left -= 1
            #move the smaller distant element. (basically don't move the pointer that has the biggest element)
            else:
                
                if x - arr[left] > arr[right] - x:
                    res.append(arr[right])
                    right += 1
                else:
                    res.appendleft(arr[left])
                    left -= 1
            k -= 1
        return res
    
    
    def binarySearch(self, arr, x):
        left = 0 
        right = len(arr)-1
        
        while left < right:
            
            mid = left + (right-left)//2
            
            if arr[mid] == x:
                return mid
            #edge case: right = mid not right = mid-1 ([1,2,3,3,13,14])
            elif arr[mid] > x:
                right = mid
            else:
                left = mid + 1
                
        if left == 0:
            return 0 
        
        if abs(arr[left] - x) < abs(arr[left-1] - x):
            return left 
        
        return left - 1