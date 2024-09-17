# APPROACH 1: TWO POINTERS
# Time Complexity : O(n + m), n: len(forwardRouteList), m: len(returnRouteList)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : N/A
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. two pointers -> low at begining of forward list and high at end of return list. 
# 2. Each time take the sum of the distances and if within the limit -> check if greater than the max distance found so far or not
# 3. If greater than max distance found so far, discard the previous results and form new one. If equal to the max distance found so far, append to the current result
# 4. If current sum is greater than limit, dec high. if current sum is less than limit, inc low.

def getOptimizedUtilize(maxTravelDist, forwardRouteList, returnRouteList):
    if forwardRouteList is None or returnRouteList is None:
        return None

    low, high, max_so_far, result = 0, len(returnRouteList) - 1, float('-inf'), []
    while low < len(forwardRouteList) and high >= 0:
        curr_sum = forwardRouteList[low][1] + returnRouteList[high][1]
        if curr_sum <= maxTravelDist:
            if curr_sum > max_so_far:
                max_so_far = curr_sum
                result = [[forwardRouteList[low][0], returnRouteList[high][0]]]
            elif curr_sum == max_so_far:
                result.append([forwardRouteList[low][0], returnRouteList[high][0]])

            low += 1

        else:
            high -= 1

    return result



# APPROACH 2: BINARY SEARCH
# Time Complexity : O(n lg m), n: len(shorter route list) and m: len(longer route list)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : N/A
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Ensure that forwardRouteList is the shorter one than returnRouteList
# 2. For each element of the forwardRouteList, target is the max allowed distance - element and do a Binary Search for it in returnRouteList (not exact closest search)
# 3. Keep track of global max found so far, to udate result appropriately. 
# 4. If the element is greater than target, shift to left half, else shift to right half

def getOptimizedUtilize(maxTravelDist, forwardRouteList, returnRouteList):
    if forwardRouteList is None or returnRouteList is None:
        return None

    if len(forwardRouteList) > len(returnRouteList):
        getOptimizedUtilize(maxTravelDist, returnRouteList, forwardRouteList)
        
    result, max_so_far = [], float('-inf')
    for route in forwardRouteList:
        target = maxTravelDist - route[1]
        low, high = 0, len(returnRouteList) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if returnRouteList[mid][1] <= target:
                if max_so_far < target + route[1]:
                    max_so_far = returnRouteList[mid][1] + route[1]
                    result = [[route[0], returnRouteList[mid][0]]]
                else:
                    result.append([route[0], returnRouteList[mid][0]])
                low = mid + 1

            else:
                high  = mid - 1

    return result
