# Time complexity: O(n-k)
# Space complexity: O(1)
# Approach: initiate a left and right pointer from 0 and last index respectively
# Run a loop until the space between left and right is k
# in the loop, compare the absolute of differences between left and x and right and x
# increment the left pointer if left's value difference with x is more than right's
# else decrement right pointer
# after coming out of the loop, add the values from left to right pointer to a list and return it.


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr)-1
        while right-left+1 > k:
            if(abs(arr[left]-x)>abs(arr[right]-x)):
                left = left + 1
            else:
                right = right -1
        result = []
        for i in range(left, right+1):
            result.append(arr[i])
        return result
            
                
        
        
        