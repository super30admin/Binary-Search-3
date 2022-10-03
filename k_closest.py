# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        #To get left and right pointers
        #right one will be len of arr - k to get the window size
        l,r = 0 , len(arr)-k
        
        #Noraml binary search
        while l<r:
            mid=(l+r)//2
            
            #the difference between the number and mid is Start point
            startDist=x-arr[mid]
            
            #The difference between the mid+window size and x will be thenend of the window
            endDist=arr[mid+k]-x
            
            #The the start distance is greather then move the left pointer
            if startDist>endDist:
                l=mid+1
            #Else move the right to the mid to eleminate the rest of them
            else:
                r=mid
        
        #Return from the low to l+k as we want the k nearest elements of x
        return arr[l:l+k]