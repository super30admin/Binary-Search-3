"""
Time complexity -O(N)

Have a fast ptr and slow pointer compare the unit distance between 2 ptrs placing them between k distance and move them accordingly. Low pointer gives the first index of k closest element

"""

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        res=[]
        if(arr is None or len(arr)==0):
            return res
        low=0
        high=len(arr)-1
        while(high-low+1>k):
            distL=abs(x-arr[low])
            distR=abs(arr[high]-x)
            
            if(distL>distR):
                low+=1
            else:
                high-=1
        
        for i in range(low,low+k):
            res.append(arr[i])
        
        return res
        