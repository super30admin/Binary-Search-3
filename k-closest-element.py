class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        '''
        Binary Search and 2 Pointers
        Time Complexity: O(logn + n)
        Space Complexity: O(1)
        Missed a Few Edge Cases.
        '''
        beg = 0
        end = len(arr)-1
        t = 0
        # min element equal to target
        
        while beg<=end:
            mid = (beg+end)//2
            if(arr[mid]>=x):
                end = mid - 1
            else:
                beg = mid + 1
        
        
        if(end==-1):
            t = 0
        elif(beg==len(arr)):
            t = end
        else:
            # since beg is greater than end, we will apply following condition
            if(abs(arr[end]-x)>abs(arr[beg]-x)):
                t = beg
            else:
                t = end
        print()
        # 2 pointer
        i = t -1
        j = t + 1
        o = deque([arr[t]])
        while(len(o)<k):
            if j<len(arr) and ((i<0) or (abs(arr[i]-x)>abs(arr[j]-x))):
                o.append(arr[j])
                j+=1
            else:
                o.appendleft(arr[i])
                i-=1
        
        
        return o
