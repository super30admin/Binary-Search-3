#Time complexity: O(n - k)
#Space complexity: O(1)

#Accepted on Leetcode

#Approach
#Use Binary Search to check 'window' of length k + 1 each time -> start from l = 0 and h = n - k (as window is of k elements)
#Each time check the left and right ends of the window (formed by mid and mid + kth element) -> move window to whichever end's element has the smaller absolute difference with x
#At the end when low becomes == high: we will be left with the correct windoW!

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        l = 0
        h = n - k
        
        while l < h:
            mid = (l+ h)//2
            distS = x - arr[mid]
            distT = arr[mid + k] - x

            if distS > distT:
                l = mid + 1
            else:
                h = mid
        
        return arr[l: l + k]
        