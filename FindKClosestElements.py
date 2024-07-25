# Time Complexity :
# O(n-k), n = size of arrray, k is given value for finding k closest elements 

# Space Complexity : 
# O(k)


# Approach:
# Two pointer approach and finding differences between element at left and right pointers with "x".
# Then advanbce, left or right pointer based on which difference is larger.
# Repeat the above process untill "right-left+1" > k.

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        # =============> Approach: TC = O(n+k) or O(V+E), SC = O(n) or O(V) <==============# k = length  of trust array
        if not arr or len(arr)==0:
            return []
        
        left = 0
        right = len(arr)-1

        result = []    # Result answer

        while(right-left+1 > k):    # For k closest elements  
            diffL = abs(arr[left]-x)
            diffR = abs(arr[right]-x)

            # this to take into account returning the elements in sorted order
            if diffR >= diffL:
                right -= 1
            else:
                left += 1

        for i in range(left, right+1):
            result.append(arr[i])
        
        return result