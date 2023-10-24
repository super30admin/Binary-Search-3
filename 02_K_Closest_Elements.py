'''
Time Complexity : O(logn)
Space Complexity : O(1)


'''

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        start = 0
        end = n - k #because this is the highest value start can have since the windowsize is k
        mid = 0
        
        while start<end:
            mid = start + (end-start)//2
            
            if (arr[mid] == arr[mid+k]):
                if(x<=arr[mid]):
                    end = mid
                else:
                    start = mid+1
            else:
                d1 = abs(x-arr[mid])
                d2 = abs(x-arr[mid+k])
                
                if d1 <= d2:
                    end = mid
                else:
                    start = mid+1
        ans = []
        
        for i in range(start, start+k):
            ans.append(arr[i])
        return ans
            
        