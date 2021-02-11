#Time COmplexity:O(k+log n)
#Space Complexity:O(1)

#approach:we use binary search to find the closest element to k and once thge position of x is found we find its k neighbors to identify closest elements.

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result=[]
        closest=self.binarysearch(arr,x)
        result.append(arr[closest])
        left=closest-1
        right=closest+1
        while k>1:
            if left<0:
                result.append(arr[right])
                right+=1
            elif right==len(arr):
                result.insert(0,arr[left])
                left-=1
            else:
                if x-arr[left]>arr[right]-x:
                    result.append(arr[right])
                    right+=1
                else:
                    result.insert(0,arr[left])
                    left-=1
            k-=1
        return result
    
    def binarysearch(self,arr:List[int],x:int)->int:
        low=0
        high=len(arr)-1
        while(low<high):
            mid=low+(high-low)//2
            if arr[mid]==x:
                return mid
            elif arr[mid]<x:
                low=mid+1
            else:
                high=mid
        if low==0:
            return low
        if abs(arr[low]-x)< abs(arr[low-1]-x):
            return low
        return low-1
                