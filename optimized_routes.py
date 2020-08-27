class Solution:
    def OptimizedAir3(self, maxTravelDist, forwardRouteList, returnRouteList):
        forwardRouteList.sort(key = lambda x:x[1])
        returnRouteList.sort(key = lambda x:x[1])
        maxDist = -1
        maxDistlist = []
        for i in forwardRouteList:
            compliment = maxTravelDist - i[1]
            nearest = self.getNearestDist(returnRouteList, compliment)
            if nearest != -1:
                totalDist = i[1] + returnRouteList[nearest][1]
                if totalDist >= maxDist:
                    if totalDist > maxDist:
                        maxDistlist = []
                        maxDist = totalDist
                    maxDistlist.append((i[0], returnRouteList[nearest][0]))
        return maxDistlist
    def getNearestDist(self, arr, target):
        low = 0
        high = len(arr) - 1
        nearest = -1
        while low <= high:
            mid = low + (high - low)//2
            if arr[mid][1] == target:
                return mid
            elif arr[mid][1] > target:
                high = mid - 1
            else:
                nearest = mid
                low = mid + 1
        return nearest