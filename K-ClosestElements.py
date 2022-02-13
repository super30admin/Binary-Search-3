'''
Solution:
1.  First, compute the range where x can be present in the given array using Binary Search in logN time.
    Range gives the before and after index where x falls and if x is present in the array => range is the index itself
    both lower and higher indices.
2.  Once we find the range, move k elements either left or right based on the distances from x and return the subarray
    from left to right indices.
Time Complexity: O(logN + k)    | Space Complexity: O(1)
--- Passed all testcases successfully on leetcode
'''
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        n = len(arr)
        low = 0
        high = n-k

        while low < high:
            mid = int(low + (high -low)/2)
            distStart =  x - arr[mid]
            distH = arr[mid+k] - x 

            if distStart> distH:
                low = mid + 1
            else:
                high = mid
        
        result = []
        for i in range(low,low+k,1):
            result.append(arr[i])
        
        return result
            
    
            
'''
 Linear Solution
 Time Complexity: O(N + k)    | Space Complexity: O(1)
'''       
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        n = len(arr)
        low = 0
        high = n-1

        while high - low +1 > k:
            distL = abs(arr[low] - x)
            distH = abs(arr[high] -x)

            if distL> distH:
                low += 1
            else:
                high -= 1
        
        result = []
        for i in range(low,high+1,1):
            result.append(arr[i])
        
        return result
            
    
            
        