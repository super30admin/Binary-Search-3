class Solution:
    """
    Time Complexity: O(N)
    Space Complexity: O(1)
    """
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # Using two pointer
        left = 0
        right = len(arr)-1
        while right - left +1 >k:
            ldiff = abs(arr[left]-x)
            rdiff = abs(arr[right]-x)
            if rdiff >= ldiff:
                right -= 1
            else:
                left +=1
        return arr[left:right+1]
            
