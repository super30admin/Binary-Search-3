'''
Approach: Using 2 pointers, check absolute distance for elements at 2 pointers with k. If distance of x with with p1 is greater than with p2 move p1 pointer else move p2 pointer. After getting p1 and p2 to a window of k. iterate from p1 to p2 to get all the elements of result.

Time complexity: O(N)
Space complexity:O(1)

Passes all testcases in leetcode

'''

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        p1 = 0
        p2 = len(arr)-1
        res = []
        
        while(p2-p1+1>k):
            l = abs(arr[p1]-x)
            r = abs(arr[p2]-x)
            if(l>r):
                p1+=1
            else:
                p2-=1
        for i in range(p1,p2+1,1):
            res.append(arr[i])
        return res
            
            
            
        
