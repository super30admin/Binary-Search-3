#Time Complexity :O(log n + k)
#Space Complexity :O(1) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        if(arr==None or len(arr)==0):
            return []
        
        res=collections.deque()
        #get the closest element index 
        closestIndex=self.BS(arr,x)
        res.append(arr[closestIndex])
        
        #search for other closest using linear steps
        left,right=closestIndex-1,closestIndex+1
        while(k>1):
            if(left<0):
                res.append(arr[right])
                right+=1
            elif(right==len(arr)):
                res.appendleft(arr[left])
                left-=1
            elif(x-arr[left]>arr[right]-x):
                res.append(arr[right])
                right+=1
            else:
                res.appendleft(arr[left])
                left-=1
            k-=1
        return res
    
    #get the closest index using Binary search
    def BS(self,arr,x):
        low=0
        high=len(arr)-1
        
        while(low<high):
            mid=low+(high-low)//2
            if(arr[mid]==x):
                return mid
            if(arr[mid]>x):
                high=mid
            else:
                low=mid+1
        
        #if exact match not present return closest element
        
        #It means the closest is at frst index 
        if(low==0):
            return 0
        if(abs(arr[low]-x) < abs(arr[low-1]-x)):
            return low
        else:
            return low-1
            
            
            
            
            
            
            
            
            