#leetcode - 658 - Find k closet element - https://leetcode.com/problems/find-k-closest-elements/
#Time complexity - O(max(logn,k))
# Approach - Binary search


class Solution(object):
    def findClosestElements(self, A, k, x):
        left =0
        right=len(A)-k-1
        while left<=right:
            mid=left+(right-left)//2
            if abs(A[mid]-x)>abs(A[mid+k]-x):
                left=mid+1
            else:
                right=mid-1
        res=[]
        for i in range(0,k):
            res.append(A[left+i])
        return res
            
            



class Solution(object):
    def findClosestElements(self, A, k, x):
        left=0
        right=len(A)-k
        while left<right:
            mid=left+(right-left)//2
            if abs(x-A[mid])>abs(A[mid+k]-x):
                 left=mid+1
            else:
                 right=mid
        return A[left:left+k]
       