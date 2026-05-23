# https://leetcode.com/discuss/post/935671/amazon-sde1-oa-2020-prime-air-route-by-a-pxk4/

# Given:
# Max travel distance = 10000

# (unique id of forward route, distance)
# forwardRoutes = [(1,1000),(2,2000),(3,4000),(4,5000),(5,5500),(6,6000)]
# (unique id of backward route, distance)
# backwardRoutes= [(1,1500),(2,2500),(3,3500),(4,4000),(5,5000),(6,6000)]
# output = [[4,5],[6,4]]

# Return a list of pairs of integers representing the pairs of IDs of forward and return shipping routes 
# that optimally utilize the given aircraft. If no route possible, return list with empty pair,


# Example 1:
# maxTravelDistance = 7000
# forwardRouteList = [(1,2000),(2,4000),(3,6000)]
# returnRouteList = [(1,2000)]
# output = [[2,1]]
# two pointers and or binary search

class Solution:
    def optimalAirRoute(self, forward, backward, target):
        result = []
        forward.sort(key=lambda a: a[1])
        backward.sort(key=lambda a: a[1])

        l = 0
        r = len(backward)-1
        maxSum = 0

        while l < len(forward) and r >=0:
        	sum = forward[l][1]+backward[r][1]
        	if sum > target:
        		# too far
        		r-=1
        	else:
        		if sum > maxSum:
        			result = []
        			maxSum=sum 
        		if sum == maxSum:
        			i = r
        			while i >= 0 and backward[i][1]==backward[r][1]:
        				result.append([forward[l][0],backward[i][0]])
        				i-=1
        		l+=1
        print(result)
        return result 

        

sol = Solution()
forwardRoutes = [(1,1000),(2,2000),(3,4000),(4,5000),(5,5500),(6,6000)]
backwardRoutes = [(1,1500),(2,2500),(3,3500),(7,4000),(8,4000),(4,4000),(5,5000),(6,6000)]
sol.optimalAirRoute(forwardRoutes,backwardRoutes,10000)


# [[(3,4000),(6,6000)],[(4,5000),(5,5000)],[(6,6000),(4,4000)]]
# result =[[3,6],[4,5],[6,4],[6,8],[6,7]]
# maxSum=10000
# sum = 10000

# target = 10000
# forwardRoutes = [(1,1000),(2,2000),(3,4000),(4,5000),(5,5500),(6,6000)]
#                                                                   l
# backwardRoutes= [(1,1500),(2,2500),(3,3500),(7,4000),(8,4000),(4,4000),(5,5000),(6,6000)]
#                     									 r