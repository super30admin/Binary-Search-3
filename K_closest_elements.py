# TC: log(N)+O(K)
# SC: O(K)


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low=0
        high=len(arr)-1

        if x<arr[0]:
            return arr[:k]
        
        if x>arr[-1]:
            return arr[-k:]

        idx=-1
        while low<high:
            mid=(low+high)//2
            if arr[mid]==x:
                idx=mid
                break
            elif arr[mid]<x:
                low=mid+1
            else:
                high=mid-1

        if idx==-1:
            idx=low

        if low>0 and abs(arr[low-1]-x)<=abs(arr[low]-x):
            idx=low-1

        if high<len(arr)-1 and abs(arr[high+1]-x)<abs(arr[high]-x):
            idx=high+1
            
        print("idx "+str(idx) )
        l=h=idx
        while h-l<k-1:
            if l>0 and h<len(arr)-1:
                if abs(arr[l-1]-x)<=abs(arr[h+1]-x):
                    l-=1
                elif abs(arr[l-1]-x)>abs(arr[h+1]-x):
                    h+=1

            elif l==0:
                h+=1
            else:
                l-=1
            print(str(l)+" "+str(h))
        print("final "+str(l)+str(h))
       
        return arr[l:h+1]


        # low=0
        # high=len(arr)-1

        # while high-low>=k:
        #     distl=abs(x-arr[low])
        #     disth=abs(x-arr[high])

        #     if distl>disth:
        #         low+=1
        #     else:
        #         high-=1
        
        # li=[]
        # while low<=high:
        #     li.append(arr[low])
        #     low+=1
        
        # return li
        


        