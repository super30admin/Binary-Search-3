#Time Complexity :
#Space Complexity :
#Did this code successfully run on Leetcode : Yes

class Solution:
    # def getOptimalRoute(maxTravelDist, forwardRouteList, returnRouteList):
    #     result = []
    #     for f in forwardRouteList:
    #         for r in returnRouteList:
    #             curr = f[1]+r[1]
    #             if curr < maxTravelDist:
    #                 if result[2] < curr:
    #                     results = [f[0], r[0], curr]
    #                 elif result[2] == curr:
    #                     results.append([f[0], r[0], curr])
    #     return [result[:2]] if result[0] != float("-inf") else [[]]
