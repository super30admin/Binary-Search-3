 #Time Complexity:- O(n-k)
 #Space Complexity :- O(1)
 
 class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        start = 0
        end = len(arr)-1

        if start == end:
            return arr
        while end-start+1 >k:
            if abs(x-arr[start]) <= abs(x-arr[end]):
                end -=1
            else:
                start+=1
            print(start, end, abs(end-start+1))
        return arr[start:end+1]