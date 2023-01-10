#time complexity: O(log(n-k))+k
#space complexity: O(1)
#ran on leetcode: Yes
#use binary search and see if x- arr[mid] or arr[mid+k]-x is greater and reduce change low or higher pointer accordingly.
class Solution:
    def smallest(self,arr,k,x):
        low=0
        high=len(arr)-k
        while(low<high):
            mid=(low+high)//2
            start=x-arr[mid]
            end=arr[mid+k]-x
            if(start<=end):
                #move left
                high=mid
            else:
                low=mid+1

        return low
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        L=[]
        point=self.smallest(arr,k,x)
        print(point)
        return arr[point:point+k]

        
