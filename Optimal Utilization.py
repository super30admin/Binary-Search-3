# Question link = https://leetcode.com/discuss/interview-question/373202
# TC: O(N*logM)
# SC: O(N)

from collections import defaultdict

class Solution(object):
    def optimalFlightPath(self, target, A, B):      
        A = sorted(A, key=lambda x:x[1])
        B = sorted(B, key=lambda x:x[1])
        diff = float('inf')
        output = []
        for i in range(len(B)):
            index = self.bsearch(A,target-B[i][1])

            if target - A[index][1] - B[i][1] == diff:
                output.append([A[index][0],B[i][0]])
            elif 0 <= target - A[index][1] - B[i][1] < diff:
                diff = target - A[index][1] - B[i][1]        
                output = [ [A[index][0], B[i][0]] ]
            return output

    def bsearch(self,arr, target):
        left = 0
        right = len(arr) - 1
        while left < right:
            mid = (left + right) // 2 + 1
            if arr[mid][1] == target:
                return mid
            elif arr[mid][1] < target:
                left = mid
            else:
                right = mid - 1
        return right
    
obj = Solution()
a = [[1, 3], [2, 5], [3, 7], [4, 10]]
b = [[1, 2], [2, 3], [3, 4], [4, 5]]
target = 10
ans = obj.optimalFlightPath(target, a, b)
print(ans)           