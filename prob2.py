#TC: 0(N-K)
#SC : 0(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if(len(arr)==0):
            return []
        left = 0
        print(left)
        right = len(arr) - 1
        print(right)
        while(left-right+1 > k):
            distleft = x - arr[left]
            distright = arr[right] - x
            if(distleft > distright):
                left += 1
            else:
                right -= 1
        result = []
        for i in range(left,right):
            result.append(arr[i])
        return result
        