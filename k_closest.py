# O(N) TIME AND O(1) SPACE
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - 1
        
        while(high-low >= k):
            if(abs(arr[low]-x) > abs(arr[high]-x)):
                low+=1
            else:
                high-=1;
        return arr[low:high+1]