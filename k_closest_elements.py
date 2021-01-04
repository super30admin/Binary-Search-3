class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        #O(log(n-k))+O(k)>>bs on reduced size array and result run through k elements in araray
        res=[]
        if not arr:
            return res
        l=0
        #discarding k elements from back already
        #considering h to be my last starting point
        h=len(arr)-k
        h=self.bs(arr,k,x,l,h)
        return arr[h:h+k]
    def bs(self,arr,k,x,l,h):
        while l<=h:
            first=l+(h-l)/2
            last=first+k-1
            if first-1>=0 and x-arr[first-1]<=arr[last]-x:
                h=first-1
            elif last+1<len(arr) and x-arr[first]>arr[last+1]-x:
                l=first+1
            else:
                return first
        
            
        
        