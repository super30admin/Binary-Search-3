#Time Complexity: O(log(n-k)+k) The binary search portion of the algorithm (while(left < right)) runs O(log(n-k)) + slicing the arr for k elemetn O(k)
#Space Complexity: O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        left = 0
        right = n-k
        while(left<right):
            mid = left+(right-left)//2
            #To check if x closer to the first element or last element in the window size of k
            if(x-arr[mid]>arr[mid+k]-x):
                #If x-arr[mid]>arr[mid+k]-x then we can conclude that element after mid are closer to x, so we move the left pointer after mid and continue the search
                left = mid+1
            else:
                #If not then elements at mid and before mid are closer to x, so we move the right pointer to mid
                right = mid
        #This allows to return the k closest elements
        return arr[left:left+k]