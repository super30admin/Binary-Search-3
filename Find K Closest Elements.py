#time: O(k+log(n))
#space: O(1)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if(arr==None or len(arr)==0):
            return []
        closest=self.binary(arr,x,k)
        q=deque()
        q.append(arr[closest])
        low=closest-1
        high=closest+1
        for i in range(1,k):
            if(low<0):
                q.append(arr[high])
                high+=1
            if(high>len(arr)-1):
                q.appendleft(arr[low])
                low=low-1
                
            if(low>=0 and high<=len(arr)-1):
                if(abs(arr[low]-x)<=abs(arr[high]-x)):
                    q.appendleft(arr[low])
                    low=low-1
                else:
                    q.append(arr[high])
                    high+=1
        return q
                
                    
    def binary(self,arr,x,k):
        low=0
        high=len(arr)-1
        while(low<high):
            mid=low+(high-low)//2
            if(arr[mid]==x):
                return mid
            elif(arr[mid]>x):
                high=mid
            else:
                low=mid+1
        if(abs(arr[low]-x)>=abs(arr[low-1]-x)):
            return low-1
        else:
            return low
            
            
            