"""
Runtime Complexity:
O(n-k) - We dont go through all the elements because we constrict the while loop by using left and right pointers and when the value is greater than k, the loop breaks out.
Space Complexity:
O(1)- no extra space was required to compute the solution. Hence constant.
Yes, the code worked on leetcode.
Issues while coding - No

"""

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr)-1
        result = []
        while right-left+1>k:
            if (abs(arr[left]-x)> abs(arr[right]-x)):
                left+=1
            else:
                right-=1
        for i in range(left,right+1):
            result.append(arr[i])
        return result
            
        