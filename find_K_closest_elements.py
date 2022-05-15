#Leetcode 658 https://leetcode.com/problems/find-k-closest-elements/

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        '''   
        Brute force
        TC: O(nlogn)+O(klogk)
     
        sorted_arr = sorted(arr, key = lambda num: abs(x - num))
        print(sorted_arr)
        result = []
        for i in range(k):
            result.append(sorted_arr[i])
        return sorted(result)
        '''
        
        # Using binary search, first establish left and right bounds.
        # right max can be len(arr)-k, beyond that if the right pointer is moved, it will go out         # of bounds ie, it cannot accomodate k elements
        left = 0
        right = len(arr)-k
        
        while left<right:
            mid = (left + right) // 2
            
            if x-arr[mid] > arr[mid+k]-x:
                left = mid+1
            else:
                right = mid
                
        return arr[left:left+k]
    
#TC: O(log(n-k)+k)  SC: O(1)