from bisect import bisect, bisect_left, bisect_right
from typing import List


class Solution:
    def optimize_air_routes(self, maxTravelDist, forwardRouteList: List[List[int]], returnRouteList: List[List[int]]) -> \
            List[List[int]]:
        """
            Time Complexity - O(m+n)
                'm' is the length of forwardlist, 'n' is the length of return route list.
            Space Complexity - O(1)
        """
        # forward route
        low = 0
        # return route
        high = len(returnRouteList) - 1
        cur_max = 0
        result = []
        tmp_result = []
        while low < len(forwardRouteList) and high >= 0:
            cur_total = forwardRouteList[low][1] + returnRouteList[high][1]
            if cur_total == maxTravelDist:
                result.append([forwardRouteList[low][0], returnRouteList[high][0]])
                low += 1
                high -= 1
            elif not result and cur_max <= cur_total < maxTravelDist:
                if cur_max == cur_total:
                    tmp_result.append([forwardRouteList[low][0], returnRouteList[high][0]])
                else:
                    tmp_result = [[forwardRouteList[low][0], returnRouteList[high][0]]]
                    cur_max = cur_total
            if (low < len(forwardRouteList) and high >= 0) and \
                    forwardRouteList[low][1] + returnRouteList[high][1] > maxTravelDist:
                high -= 1
            else:
                low += 1
        if not result:
            result = tmp_result
        return result


if __name__ == '__main__':
    print(Solution().optimize_air_routes(8000,
                                         [[1, 2000], [2, 4000], [3, 6000]],
                                         [[1, 2000], [4, 3000]]
                                         ))
    """
    Output:
    [[2,1]]
    
    Explanation:
    There are only three combinations [1,1],[2,1],and [3,1], which have a total of 4000, 6000, and 8000 miles, 
    respectively. Since 6000 is the largest use that does tnot exceed 7000, [2,1] is the optimal pair.
    """
    print(Solution().optimize_air_routes(18000,
                                         [[1, 3000], [2, 5000], [3, 7000], [4, 10000]],
                                         [[1, 2000], [2, 3000], [3, 4000], [4, 5000]]
                                         ))
    """"
    Output:
    [[2,4],[3,2]]
    """
