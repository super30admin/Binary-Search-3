# Not on Leetcode
      #  Runtime - O(n log m) where m is length of longest array and n is length of shortest array
      #  Memory - O(1)

class Solution:
    def __init__(self):
        self.maxdist = 0
        self.pair = [-1]* 2
        
    def binary_search(self, arr, target):
        low = 0
        high = len(arr)-1
        while low <= high:
            mid = low + (high-low)//2
            if arr[mid][1] == target:
                return arr[mid]
            elif arr[mid][1] > target:
                high = mid - 1
            else:
                low = mid + 1
        return arr[low - 1]

    def main(self, x, y, target):
        if not x or not y:
            return []
        l1 = len(x)
        l2 = len(y)
        if l1 > l2:
            return self.main(y, x, target)
        for i in range(l1):
            a = self.binary_search(y, target - x[i][1])
            if x[i][1] + a[1] > self.maxdist and self.maxdist <= target:
                self.maxdist = x[i][1] + a[1]
                self.pair = [i,a[0]]
        print("Maximum distance nearest to target", target," is covered in ", self.pair, " with max distance as: ", self.maxdist)
        
maxTravelDist = 7000
forwardRouteList = [[1,2000]]  
returnRouteList = [[1,2000],[2,4000],[3,6000]]

solution = Solution()
solution.main(forwardRouteList,returnRouteList,maxTravelDist)

maxTravelDist = 11000
forwardRouteList = [[1,3000],[2,4000],[3,5000],[4,10000]]  
returnRouteList = [[1,2000],[2,3000],[3,4000]]
solution.main(forwardRouteList,returnRouteList,maxTravelDist)
